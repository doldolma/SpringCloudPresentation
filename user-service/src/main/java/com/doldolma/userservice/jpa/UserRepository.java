package com.doldolma.userservice.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findById(int id);

    Iterable<UserEntity> findAllByBelongsTo(String belongsTo);

    List<UserEntity> findAllByNameContainsOrNicknameContainsOrNicknameEngContains(String name,
        String nickname, String nicknameEng);
}
