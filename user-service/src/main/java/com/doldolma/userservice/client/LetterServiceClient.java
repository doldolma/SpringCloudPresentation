package com.doldolma.userservice.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "letter-service")
public interface LetterServiceClient {
    @GetMapping("/letters/{id}")
    List<String> getLetters(@PathVariable String id);

    @GetMapping("/letters/{id}/count")
    Long getLettersCount(@PathVariable String id);
}
