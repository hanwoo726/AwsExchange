package com.lec.spring.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.spring.domain.ExChange;
import com.lec.spring.repository.ChangeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChangeService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final ChangeRepository changeRepository;

    public ChangeService(RestTemplate restTemplate, ObjectMapper objectMapper, ChangeRepository changeRepository) throws Exception{
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.changeRepository = changeRepository;
    }

    public void fetchDataAndSave() throws IOException {
        String url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=55TnvkQvihWfjLkS2RLroNZoIpIKVmri&searchdate=&data=AP01";
        String jsonResponse = restTemplate.getForObject(url, String.class);

        // JSON 배열을 List<ExChange>로 변환
        List<ExChange> exchangeData = filterExchangeData(jsonResponse);

        // 변환된 데이터를 데이터베이스에 저장
        saveExchangeData(exchangeData);
    }

    private List<ExChange> filterExchangeData(String jsonResponse) throws IOException {
        List<ExChange> filteredData = new ArrayList<>();

        // JSON 데이터를 읽어들임
        JsonNode rootNode = objectMapper.readTree(jsonResponse);

        // JSON 배열을 순회하며 원하는 데이터만 필터링
        for (JsonNode node : rootNode) {
            String curUnit = node.get("cur_unit").asText();
            String bkpr = node.get("bkpr").asText();
            String ttb = node.get("ttb").asText();
            String tts = node.get("tts").asText();
            String curName = node.get("cur_nm").asText().toLowerCase();
            LocalDate date = LocalDate.now();

            // 특정 조건에 따라 데이터를 필터링 (예: USD, EUR 통화만)
            if ((curUnit.equals("USD") || curUnit.equals("EUR") || curUnit.equals("JPY(100)"))
            && changeRepository.findBycurNameAndCreatedAt(curUnit.toLowerCase(), date).isEmpty()){
                ExChange exChange = new ExChange();
                exChange.setName(curName);
                exChange.setData(bkpr);
                exChange.setMin(ttb);
                exChange.setMax(tts);
                exChange.setCurName(curUnit.toLowerCase());

                filteredData.add(exChange);
            }
        }

        return filteredData;
    }

    private void saveExchangeData(List<ExChange> exchangeData) {
        changeRepository.saveAll(exchangeData);

    }

    // 모든 ExChange 데이터를 반환
    public List<ExChange> getAllExchangeData() {
        return changeRepository.findAll();
    }

    public List<ExChange> findExChange(String name){
        return changeRepository.findBycurName(name);
    }

    // 특정 통화 코드에 해당하는 ExChange 데이터를 반환
    public List<ExChange> getExchangeDataByCurUnit(String curName) {
        return changeRepository.findBycurName(curName);
    }
}
