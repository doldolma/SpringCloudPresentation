package com.doldolma.letterservice.service;

import com.doldolma.letterservice.repository.LetterEntity;
import java.util.List;

public interface LetterService {
    List<LetterEntity> getLettersByUserId(String receivedUserId);
    void createLetter(LetterEntity letter);
}
