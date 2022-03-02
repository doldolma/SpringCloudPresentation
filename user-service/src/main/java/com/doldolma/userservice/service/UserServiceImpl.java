package com.doldolma.userservice.service;

import com.doldolma.userservice.client.LetterServiceClient;
import com.doldolma.userservice.jpa.UserEntity;
import com.doldolma.userservice.jpa.UserRepository;
import io.micrometer.core.annotation.Timed;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LetterServiceClient letterServiceClient;
    private final CircuitBreakerFactory circuitBreakerFactory;

    public UserServiceImpl(UserRepository userRepository, LetterServiceClient letterServiceClient
        , CircuitBreakerFactory circuitBreakerFactory) {
        this.userRepository = userRepository;
        this.letterServiceClient = letterServiceClient;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @Override
    @Timed(value = "findUser")
    public UserEntity findUser(String id) {
        UserEntity user = userRepository.findById(Integer.parseInt(id));

        CircuitBreaker circuitbreaker = circuitBreakerFactory.create("circuitbreaker");
        user.setLetters(circuitbreaker.run(() -> letterServiceClient.getLetters(id),
            throwable -> new ArrayList<>()));
        return user;
    }

    @Override
    @Timed(value = "findAllUsers")
    public Iterable<UserEntity> allUsers() {
        return userRepository.findAll();
    }

    @Override
    @Timed(value = "findTeam")
    public Iterable<UserEntity> findTeam(String team) {
        return userRepository.findAllByBelongsTo(team);
    }

    @Override
    @Timed(value = "findName")
    public Iterable<UserEntity> findName(String name) {
        return userRepository.findAllByNameContainsOrNicknameContainsOrNicknameEngContains(name,
            name, name);
    }

    @Override
    @Timed(value = "findTeamAndName")
    public Iterable<UserEntity> findTeamAndName(String name, String team) {
        Iterable<UserEntity> users = userRepository.findAllByNameContainsOrNicknameContainsOrNicknameEngContains(
            name, name, name);
        return StreamSupport.stream(users.spliterator(), false).filter(user -> {
            return user.getBelongsTo().equals(team);
        }).collect(Collectors.toList());
    }
}
