package com.practice.ldap.service;

import com.practice.ldap.api.Result;
import com.practice.ldap.entity.Person;
import com.practice.ldap.request.LoginRequest;

/**
 * @author wb
 */
public interface PersonService {

    /**
     * 登录
     *
     * @param request {@link LoginRequest}
     * @return {@link Result}
     */
    Result login(LoginRequest request);

    /**
     * 查询全部
     *
     * @return {@link Result}
     */
    Result listAllPerson();

    /**
     * 保存
     *
     * @param person {@link Person}
     */
    void save(Person person);

    /**
     * 删除
     *
     * @param person {@link Person}
     */
    void delete(Person person);

}