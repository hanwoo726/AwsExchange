package com.lec.spring.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class ExChange extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonProperty("cur_nm") // 이름
    String name;
    @JsonProperty("bkpr")   // 평균
    String data;
    @JsonProperty("ttb")    // 최저
    String min;
    @JsonProperty("tts")    // 최대
    String max;
    @JsonProperty("cur_unit")
    String curName;
}
