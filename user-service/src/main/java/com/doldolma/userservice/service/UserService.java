package com.doldolma.userservice.service;

import com.doldolma.userservice.jpa.UserEntity;

public interface UserService {
    UserEntity findUser(String userId);
    Iterable<UserEntity> allUsers();
    Iterable<UserEntity> findName(String name);
    Iterable<UserEntity> findTeam(String team);
    Iterable<UserEntity> findTeamAndName(String name, String team);
}
