package com.doldolma.userservice.controller;

import com.doldolma.userservice.jpa.UserEntity;
import com.doldolma.userservice.service.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/")
public class UserController {

    private Environment env;
    private UserService userService;

    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return env.getProperty("greeting.message");
    }

    @GetMapping("/searching")
    public ResponseEntity<?> searchUsers(@RequestParam String name, @RequestParam String team) {
        Iterable<UserEntity> result = null;
        List<UserEntity> returnData = new ArrayList<>();
        if(name.equals("all") && team.equals("all")){
            result = userService.allUsers();
        }else if(name.equals("all") && !team.equals("all")){
            result = userService.findTeam(team);
        }else if(!name.equals("all") && team.equals("all")){
            result = userService.findName(name);
        }else {
            result = userService.findTeamAndName(name, team);
        }

        result.forEach(returnData::add);

        if(returnData.size() == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("조건을 만족하는 분이 안 계십니다.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(returnData);
    }

    @GetMapping("/grew-person")
    public ResponseEntity<UserEntity> findUser(@RequestParam String id) throws Exception {
        UserEntity user = userService.findUser(id);
        if(user == null){
            throw new Exception("userNotFound");
        }

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
