package com.lec.spring.repository;

import com.lec.spring.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    void userTest(){
        User user = new User();
        user.setUsername("test01");
        user.setPassword(passwordEncoder.encode("1234"));


        System.out.println("영속성 전" + user.toString());

        userRepository.save(user);
        System.out.println("영속성 후");

    }

}