package com.roman.savuliak.agile.board.persistence;

import com.roman.savuliak.agile.board.domain.User;
import lombok.NonNull;

import java.util.Optional;

/**
 * Created by Roman on 06.02.2018.
 */
public interface IUserDao {
    Optional<User> findByUsername(@NonNull String username);
    void save(@NonNull User user);
}