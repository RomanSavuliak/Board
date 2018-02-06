package com.roman.savuliak.agile.board.services;

import com.roman.savuliak.agile.board.domain.User;

/**
 * Created by Roman on 06.02.2018.
 */
public interface IUserService {
    void add(User user);
    User getCurrentUser();
}