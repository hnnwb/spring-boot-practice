package com.practice.oauth.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wb
 */
@Data
@Table
@Entity
public class SysClientDetails implements ClientDetails {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * client id
     */
    private String clientId;

    /**
     * client 密钥
     */
    private String clientSecret;

    /**
     * 资源服务器名称
     */
    private String resourceIds;

    /**
     * 授权域
     */
    private String scopes;

    /**
     * 授权类型
     */
    private String grantTypes;

    /**
     * 重定向地址，授权码时必填
     */
    private String redirectUrl;

    /**
     * 授权信息
     */
    private String authorizations;

    /**
     * 授权令牌有效时间
     */
    private Integer accessTokenValiditySeconds;

    /**
     * 刷新令牌有效时间
     */
    private Integer refreshTokenValiditySeconds;

    /**
     * 自动授权请求域
     */
    private String autoApproveScopes;

    /**
     * 是否安全
     *
     * @return 结果
     */
    @Override
    public boolean isSecretRequired() {
        return this.clientSecret != null;
    }

    /**
     * 是否有 scopes
     *
     * @return 结果
     */
    @Override
    public boolean isScoped() {
        return this.scopes != null && !this.scopes.isEmpty();
    }

    /**
     * scopes
     *
     * @return scopes
     */
    @Override
    public Set<String> getScope() {
        return stringToSet(scopes);
    }

    /**
     * 授权类型
     *
     * @return 结果
     */
    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return stringToSet(grantTypes);
    }

    @Override
    public Set<String> getResourceIds() {
        return stringToSet(resourceIds);
    }


    /**
     * 获取回调地址
     *
     * @return redirectUrl
     */
    @Override
    public Set<String> getRegisteredRedirectUri() {
        return stringToSet(redirectUrl);
    }

    /**
     * 这里需要提一下
     * 个人觉得这里应该是客户端所有的权限
     * 但是已经有 scope 的存在可以很好的对客户端的权限进行认证了
     * 那么在 oauth2 的四个角色中，这里就有可能是资源服务器的权限
     * 但是一般资源服务器都有自己的权限管理机制，比如拿到用户信息后做 RBAC
     * 所以在 spring security 的默认实现中直接给的是空的一个集合
     * 这里我们也给他一个空的把
     *
     * @return GrantedAuthority
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    /**
     * 判断是否自动授权
     *
     * @param scope scope
     * @return 结果
     */
    @Override
    public boolean isAutoApprove(String scope) {
        if (autoApproveScopes == null || autoApproveScopes.isEmpty()) {
            return false;
        }
        Set<String> authorizationSet = stringToSet(authorizations);
        for (String auto : authorizationSet) {
            if ("true".equalsIgnoreCase(auto) || scope.matches(auto)) {
                return true;
            }
        }
        return false;
    }

    /**
     * additional information 是 spring security 的保留字段
     * 暂时用不到，直接给个空的即可
     *
     * @return map
     */
    @Override
    public Map<String, Object> getAdditionalInformation() {
        return Collections.emptyMap();
    }

    private Set<String> stringToSet(String s) {
        return Arrays.stream(s.split(",")).collect(Collectors.toSet());
    }
}
