package com.lec.spring.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserJoinDTO {
    private String username;
    private String password;
}
