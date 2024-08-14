package com.lec.spring.listener;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Auditable {

    LocalDate getCreatedAt();

    void setCreatedAt(LocalDate createdAt);
}
