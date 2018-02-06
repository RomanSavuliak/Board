package com.roman.savuliak.agile.board.domain;

/**
 * Created by Roman on 06.02.2018.
 */
public enum UserField {
    USER_NAME("username");

    private final String field;

    UserField(String field) {
        this.field = field;
    }

    public String field() {
        return field;
    }
}