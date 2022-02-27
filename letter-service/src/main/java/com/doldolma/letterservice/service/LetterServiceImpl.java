package com.doldolma.letterservice.service;

import com.doldolma.letterservice.message.KafkaProducer;
import com.doldolma.letterservice.repository.LetterEntity;
import com.doldolma.letterservice.repository.LetterRepository;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class LetterServiceImpl implements LetterService{
    private final LetterRepository letterRepository;
    private final KafkaProducer kafkaProducer;

    public LetterServiceImpl(LetterRepository letterRepository, KafkaProducer kafkaProducer) {
        this.letterRepository = letterRepository;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public List<String> getLettersByUserId(String userId) {
        List<LetterEntity> letters = letterRepository.findByUserId(Integer.parseInt(userId));
        log.info("service = "+ letters.toString());
        return letters.stream().map(letter -> { return letter.getContent(); }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void createLetter(LetterEntity letter) {
        letterRepository.save(letter);
        kafkaProducer.sendLetter(letter);
    }

    @Override
    public Long countLetter(String userId) {
        return letterRepository.countByUserId(Integer.parseInt(userId));
    }
}
