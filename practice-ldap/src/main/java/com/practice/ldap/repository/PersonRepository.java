package com.practice.ldap.repository;

import com.practice.ldap.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;

@Repository
public interface PersonRepository extends CrudRepository<Person, Name> {

    /**
     * 根据用户名查找
     *
     * @param uid 用户名
     * @return com.xkcoding.ldap.entity.Person
     */
    Person findByUid(String uid);
}