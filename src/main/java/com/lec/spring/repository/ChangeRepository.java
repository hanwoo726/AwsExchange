package com.lec.spring.repository;

import com.lec.spring.domain.ExChange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ChangeRepository extends JpaRepository<ExChange, Long> {


    List<ExChange> findBycurName(String curName);

    List<ExChange> findBycurNameAndCreatedAt(String curName, LocalDate createdAt);

    List<ExChange> findAllByOrderByCreatedAtAsc();  // 오름차순 리스트 정렬
}
