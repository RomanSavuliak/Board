package com.roman.savuliak.agile.board.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Roman on 06.02.2018.
 */
public enum Role implements GrantedAuthority {
    ADMIN, USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
