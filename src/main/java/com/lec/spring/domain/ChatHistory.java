package com.lec.spring.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chathistory")
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
