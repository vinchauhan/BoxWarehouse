package com.vchauhan.security;

import com.vchauhan.domain.Role;
import com.vchauhan.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Vineet on 9/15/16.
 */
public class TokenUser extends org.springframework.security.core.userdetails.User {
    private User user;

    public TokenUser(User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }
}