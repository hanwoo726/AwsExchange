package com.lec.spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ChatHistory{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String message;
    private LocalDateTime timestamp;

    public ChatHistory(String username, String message, LocalDateTime timestamp){
        this.username = username;
        this.message = message;
        this.timestamp = timestamp;
    }


}
