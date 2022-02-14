package com.practice.orm.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2022/02/14/
 * @Description:
 */
@Data
@TableName("orm_role")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Role extends Model<Role> implements Serializable{
    /**
     * 主键
     */
    private Long id;

    /**
     * 角色名
     */
    private String name;

}
