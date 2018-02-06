package com.roman.savuliak.agile.board.services;

import com.roman.savuliak.agile.board.domain.User;
import com.roman.savuliak.agile.board.persistence.SequenceDao;
import com.roman.savuliak.agile.board.persistence.UserDao;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Roman on 06.02.2018.
 */
@Service
public class UserService implements UserDetailsService, IUserService{
    @Autowired
    private UserDao userDao;
    @Autowired private SequenceDao sequenceDao;

//    @PostConstruct
//    public void init() {
//                if (!userDao.findByUsername("admin").isPresent()) {
//            add(User.builder()
//                    .username("admin")
//                    .password(new BCryptPasswordEncoder().encode("admin"))
//                    .authorities(ImmutableList.of(Role.ADMIN))
//                    .accountNonExpired(true)
//                    .accountNonLocked(true)
//                    .credentialsNonExpired(true)
//                    .enabled(true)
//                    .build());
//        }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("user " + username + " was not found!"));
    }

    @Override
    public void add(User user) {
        user.setId(sequenceDao.getNextSequenceId(User.COLLECTION_NAME));
        userDao.save(user);
    }

    @Override
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }

}