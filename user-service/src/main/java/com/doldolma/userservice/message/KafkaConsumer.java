package com.doldolma.userservice.message;


import com.doldolma.userservice.client.LetterServiceClient;
import com.doldolma.userservice.jpa.UserEntity;
import com.doldolma.userservice.jpa.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    UserRepository repository;
    LetterServiceClient letterServiceClient;

    public KafkaConsumer(UserRepository repository, LetterServiceClient letterServiceClient) {
        this.letterServiceClient = letterServiceClient;
        this.repository = repository;
    }

    @KafkaListener(topics = "newLetter")
    public void updateQty(String kafkaMessage){
        log.info("Kafka Message : -> "+kafkaMessage);

        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<String, Object>>() {});
        } catch (JsonProcessingException ex){
            ex.printStackTrace();
        }
        String userId = map.get("userId").toString();
        UserEntity user = repository.findById(Integer.parseInt(userId));
        if(user == null) { return; }

        Long lettersCount = letterServiceClient.getLettersCount(userId);
        log.info("letter count : " + lettersCount.toString());

        user.setLettersCount(lettersCount.intValue());
        repository.save(user);
    }
}
