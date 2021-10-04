package com.psychology.studywork.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    COACH, CLIENT, ADMIN;
    @Override
        public String getAuthority(){
        return name();
    }

}
