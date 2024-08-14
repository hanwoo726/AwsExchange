package com.lec.spring.controller;

import com.lec.spring.domain.ExChange;
import com.lec.spring.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/change")
public class ChangeController {

    @Autowired
    ChangeService changeService;

    // 데이터베이스에 JSON 데이터 저장
    @CrossOrigin
    @PostMapping("/fetch")
    public String fetchDataAndSave() {
        try {
            changeService.fetchDataAndSave();
            return "데이터 가져오기 성공!";
        } catch (Exception e) {
            return "가져오기 실패 에러 내용 : " + e.getMessage();
        }
    }

    // 데이터베이스에서 모든 Exchange 데이터 가져오기
    @CrossOrigin
    @GetMapping("/list")
    public List<ExChange> getAllExchangeData() {
        return changeService.getAllExchangeData();
    }

    // 특정 통화 코드에 해당하는 데이터 가져오기
    @CrossOrigin
    @GetMapping("/{curUnit}")
    public List<ExChange> getExchangeData(@PathVariable String curUnit) {
        return changeService.getExchangeDataByCurUnit(curUnit);
    }


}
