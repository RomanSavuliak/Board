package com.roman.savuliak.agile.board.domain;

/**
 * Created by Roman on 06.02.2018.
 */
public enum  TicketField {
    USER_ID("userId");

    private final String field;

    TicketField(String field) {
        this.field = field;
    }

    public String field() {
        return field;
    }

}