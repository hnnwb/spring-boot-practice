package com.practice.orm.jdbc.template.base;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.practice.orm.jdbc.template.annotation.Column;
import com.practice.orm.jdbc.template.annotation.Ignore;
import com.practice.orm.jdbc.template.annotation.Pk;
import com.practice.orm.jdbc.template.annotation.Table;
import com.practice.orm.jdbc.template.constant.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: wbnn
 * @Date: 2021/12/23/
 * @Description:
 */
@Slf4j
public class BaseDao<T,P> {

    private JdbcTemplate jdbcTemplate;
    private Class<T> clazz;

    @SuppressWarnings(value = "unchecked")
    public BaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        clazz = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * 通用插入，自增列需添加 @Pk 注解
     * @param t 对象
     * @param ignoreNull 是否忽略null值
     * @return 操作的行数
     */
    protected Integer insert(T t,Boolean ignoreNull){
        String tableName = getTableName(t);

        List<Field> field = getField(t, ignoreNull);

        List<String> columList = getColums(field);

        String colums = StrUtil.join(Const.SEPARATOR_COMMA, columList);

        //构造占位符
        String params = StrUtil.repeatAndJoin("?", columList.size(), Const.SEPARATOR_COMMA);

        //构造值
        Object[] objects = field.stream().map(field1 -> ReflectUtil.getFieldValue(t, field1)).toArray();

        String sql = StrUtil.format("INSERT INTO {table} ({columns}) VALUES ({params})",
                Dict.create().set("table",tableName).set("columns",colums).set("params",params));
        log.debug("[执行SQL]SQL:{}",sql);
        log.debug("[执行SQL]参数：{}", JSONUtil.toJsonStr(objects));
        return jdbcTemplate.update(sql,objects);
    }

    /**
     * 通用根据主键删除
     * @param pk 主键
     * @return 影响行数
     */
    protected Integer deleteById(P pk){
        String tableName = getTableName();
        String sql = StrUtil.format("DELETE FROM {table} where id = ?",
                Dict.create().set("table",tableName));
        log.debug("[执行SQL]SQL:{}",sql);
        log.debug("[执行SQL]参数：{}",JSONUtil.toJsonStr(pk));
        return jdbcTemplate.update(sql,pk);
    }

    /**
     * 获取表名
     * @param t
     * @return
     */
    private String getTableName(T t) {
        Table table = t.getClass().getAnnotation(Table.class);
        if (ObjectUtil.isNotEmpty(table)) {
            return StrUtil.format("`{}`", table.name());
        } else {
            return StrUtil.format("`{}`",t.getClass().getName().toLowerCase());
        }
    }

    /**
     * 获取表名
     * @param
     * @return
     */
    private String getTableName() {
        Table table = clazz.getAnnotation(Table.class);
        if (ObjectUtil.isNotEmpty(table)) {
            return StrUtil.format("`{}`", table.name());
        } else {
            return StrUtil.format("`{}`",clazz.getName().toLowerCase());
        }
    }

    /**
     * 获取列
     * @param fieldList 字段列表
     * @return 列信息列表
     */
    private List<String> getColums(List<Field> fieldList){
        //构造列
        List<String> columnList = CollUtil.newArrayList();
        for (Field field : fieldList) {
            Column column = field.getAnnotation(Column.class);
            String columnName;
            if (ObjectUtil.isNotEmpty(column)) {
                columnName = column.name();
            } else {
                columnName = field.getName();
            }
            columnList.add(StrUtil.format("`{}`",columnName));
        }
        return columnList;
    }

    /**
     * 获取字段列表 过滤数据库中不存在的字段，以及自增列
     * @param t
     * @param ignoreNull
     * @return
     */
    private List<Field> getField(T t,Boolean ignoreNull){
        //获取所有字段，包含父类中的字段
        Field[] fields = ReflectUtil.getFields(t.getClass());

        //过滤数据库中不存在的字段，以及自增列
        List<Field> filterField;
        Stream<Field> fieldStream = CollUtil.toList(fields).stream()
                .filter(field -> ObjectUtil.isNull(field.getAnnotation(Ignore.class)) || ObjectUtil.isNull(field.getAnnotation(Pk.class)));

        //是否过滤字段值为null的字段
        if (ignoreNull) {
            filterField = fieldStream.filter(field -> ObjectUtil.isNotNull(ReflectUtil.getFieldValue(t, field))).collect(Collectors.toList());
        } else {
            filterField = fieldStream.collect(Collectors.toList());
        }
        return filterField;
    }
}
