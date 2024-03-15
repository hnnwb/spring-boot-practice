package com.practice.ldap.service.impl;

import com.practice.ldap.api.Result;
import com.practice.ldap.entity.Person;
import com.practice.ldap.exception.ServiceException;
import com.practice.ldap.repository.PersonRepository;
import com.practice.ldap.request.LoginRequest;
import com.practice.ldap.service.PersonService;
import com.practice.ldap.util.LdapUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.NoSuchAlgorithmException;

/**
 * @author wb
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    /**
     * 登录
     *
     * @param request {@link LoginRequest}
     * @return {@link Result}
     */
    @Override
    public Result login(LoginRequest request) {
        log.info("IN LDAP auth");

        Person user = personRepository.findByUid(request.getUsername());

        try {
            if (ObjectUtils.isEmpty(user)) {
                throw new ServiceException("用户名或密码错误，请重新尝试");
            } else {
                user.setUserPassword(LdapUtils.asciiToString(user.getUserPassword()));
                if (!LdapUtils.verify(user.getUserPassword(), request.getPassword())) {
                    throw new ServiceException("用户名或密码错误，请重新尝试");
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        log.info("user info:{}", user);
        return Result.success(user);
    }

    /**
     * 查询全部
     *
     * @return {@link Result}
     */
    @Override
    public Result listAllPerson() {
        Iterable<Person> personList = personRepository.findAll();
        personList.forEach(person -> person.setUserPassword(LdapUtils.asciiToString(person.getUserPassword())));
        return Result.success(personList);
    }

    /**
     * 保存
     *
     * @param person {@link Person}
     */
    @Override
    public void save(Person person) {
        Person p = personRepository.save(person);
        log.info("用户{}保存成功", p.getUid());
    }

    /**
     * 删除
     *
     * @param person {@link Person}
     */
    @Override
    public void delete(Person person) {
        personRepository.delete(person);
        log.info("删除用户{}成功", person.getUid());
    }

}