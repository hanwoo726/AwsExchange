package com.lec.spring.controller;

import com.lec.spring.domain.User;
import com.lec.spring.domain.UserJoinDTO;
import com.lec.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<?> test(){

        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    @PostMapping("/join")
    public String join(@RequestBody UserJoinDTO joinDTO) {
        User user = User.builder()
                .username(joinDTO.getUsername())
                .password(joinDTO.getPassword())
                .build();
        user = userService.join(user);
        if (user == null) return "JOIN FAILED";
        return "JOIN OK : " + user;
    }





}
