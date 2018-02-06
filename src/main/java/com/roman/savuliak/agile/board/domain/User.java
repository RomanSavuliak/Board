package com.roman.savuliak.agile.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * Created by Roman on 06.02.2018.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = User.COLLECTION_NAME)
public class User implements UserDetails {
    public static final String COLLECTION_NAME = "users";
    @Id
    private Long id;
    private String username;
    private List<Role> authorities;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}