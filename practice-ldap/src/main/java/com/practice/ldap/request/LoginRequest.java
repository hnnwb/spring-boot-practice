package com.practice.ldap.request;

import lombok.Builder;
import lombok.Data;

/**
 * @author wb
 */
@Data
@Builder
public class LoginRequest {

    private String username;

    private String password;

}
