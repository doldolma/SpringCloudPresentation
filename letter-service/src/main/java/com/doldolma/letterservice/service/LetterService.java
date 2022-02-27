package com.doldolma.letterservice.service;

import com.doldolma.letterservice.repository.LetterEntity;
import java.util.List;

public interface LetterService {
    List<String> getLettersByUserId(String receivedUserId);
    void createLetter(LetterEntity letter);
    Long countLetter(String userId);
}
