package com.doldolma.userservice.message;


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

    public KafkaConsumer(UserRepository repository) {
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
//
//        CatalogEntity entity = repository.findByProductId((String) map.get("productId"));
//        if(entity != null) {
//            entity.setStock(entity.getStock() - (Integer)map.get("qty"));
//            repository.save(entity);
//        }
    }
}
