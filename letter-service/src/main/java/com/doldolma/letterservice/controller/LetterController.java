package com.doldolma.letterservice.controller;

import com.doldolma.letterservice.message.KafkaProducer;
import com.doldolma.letterservice.repository.LetterEntity;
import com.doldolma.letterservice.service.LetterService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class LetterController {
    private final Environment env;
    private final LetterService letterService;
    private final KafkaProducer kafkaProducer;

    public LetterController(Environment env, LetterService letterService, KafkaProducer kafkaProducer) {
        this.env = env;
        this.letterService = letterService;
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/welcome")
    public String welcome() {

        return env.getProperty("greeting.message");
    }

    @GetMapping("/letters/{userId}")
    public List<String> getLetters(@PathVariable("userId") String userId){
        List<String> letters = letterService.getLettersByUserId(userId);
        log.info("letters = " + letters.toString());
        return letters;
    }

    @PostMapping("/letters")
    public String createLetter(@RequestBody LetterEntity letter){
        log.info(letter.toString() + "doldolma");
        letterService.createLetter(letter);
        kafkaProducer.sendLetter(letter);
        return "success";
    }
}
