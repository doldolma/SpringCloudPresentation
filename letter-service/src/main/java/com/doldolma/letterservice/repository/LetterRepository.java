package com.doldolma.letterservice.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LetterRepository extends CrudRepository<LetterEntity, Long> {
    public List<LetterEntity> findByUserId(Integer userId);
    public Long countByUserId(Integer userId);
}
