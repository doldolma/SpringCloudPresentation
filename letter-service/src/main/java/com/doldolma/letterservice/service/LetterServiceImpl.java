package com.doldolma.letterservice.service;

import com.doldolma.letterservice.repository.LetterEntity;
import com.doldolma.letterservice.repository.LetterRepository;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LetterServiceImpl implements LetterService{
    private final LetterRepository letterRepository;

    public LetterServiceImpl(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    @Override
    public List<String> getLettersByUserId(String userId) {
        List<LetterEntity> letters = letterRepository.findByUserId(Integer.parseInt(userId));
        log.info("service = "+ letters.toString());
        return letters.stream().map(letter -> { return letter.getContent(); }).collect(Collectors.toList());
    }

    @Override
    public void createLetter(LetterEntity letter) {
        letterRepository.save(letter);
    }
}
