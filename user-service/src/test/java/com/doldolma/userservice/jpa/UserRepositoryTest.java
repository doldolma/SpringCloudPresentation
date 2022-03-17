package com.doldolma.userservice.jpa;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {
    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Test
    public void setRandomLettersCount() {
        List<UserEntity> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            int randomCount = (int) (Math.random() * 30);
            user.setLettersCount(randomCount);
            System.out.println("randomCount = " + randomCount);
            users.add(user);
        });
        userRepository.saveAll(users);
    }
}