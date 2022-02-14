package com.practice.orm.mybatis.plus.activerecord;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.practice.orm.mybatis.plus.PracticeMybatisPlusApplicationTests;
import com.practice.orm.mybatis.plus.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2022/02/14/
 * @Description:
 */
@Slf4j
public class ActiveRecordTest extends PracticeMybatisPlusApplicationTests {

    @Test
    public void testActiveRecordInsert(){
        Role role = new Role();
        role.setName("VIP");
        Assertions.assertTrue(role.insert());
        log.debug("[role]={}",role);
    }

    /**
     * 测试 ActiveRecord 更新数据
     */
    @Test
    public void testActiveRecordUpdate() {
        Assertions.assertTrue(new Role().setId(1L).setName("管理员-1").updateById());
        Assertions.assertTrue(new Role().update(new UpdateWrapper<Role>().lambda().set(Role::getName, "普通用户-1").eq(Role::getId, 2)));
    }

    /**
     * 测试 ActiveRecord 查询数据
     */
    @Test
    public void testActiveRecordSelect() {
        Assertions.assertEquals("管理员", new Role().setId(1L).selectById().getName());
        Wrapper<Role> wrapper = Wrappers.<Role>lambdaQuery().eq(Role::getId,2L);
        Role role = new Role().selectOne(wrapper);
        Assertions.assertEquals("普通用户", role.getName());
        List<Role> roles = new Role().selectAll();
        Assertions.assertTrue(roles.size() > 0);
        log.debug("【roles】= {}", roles);
    }

    /**
     * 测试 ActiveRecord 删除数据
     */
    @Test
    public void testActiveRecordDelete() {
        Assertions.assertTrue(new Role().setId(1L).deleteById());
        Assertions.assertTrue(new Role().delete(new QueryWrapper<Role>().lambda().eq(Role::getName, "普通用户")));
    }

}
