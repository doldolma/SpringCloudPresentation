package com.doldolma.letterservice.service;

import static org.junit.jupiter.api.Assertions.*;

import com.doldolma.letterservice.repository.LetterEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LetterServiceImplTest {
    private final LetterService letterService;

    public LetterServiceImplTest(LetterService letterService) {
        this.letterService = letterService;
    }

}