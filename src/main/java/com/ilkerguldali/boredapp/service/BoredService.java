package com.ilkerguldali.boredapp.service;

import com.ilkerguldali.boredapp.dto.ActivityDTO;
import com.ilkerguldali.boredapp.model.Activity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class BoredService {
    private final RestTemplate restTemplate;
    private final int TIMEOUT_DURATION = 10;
    private final String BASE_ACTIVITY_URL = "http://www.boredapi.com/api/activity/";

    @Autowired
    private ModelMapper modelMapper;

    public BoredService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(TIMEOUT_DURATION))
                .setReadTimeout(Duration.ofSeconds(TIMEOUT_DURATION))
                .build();
    }

    public Activity getActivity() {
        ResponseEntity<ActivityDTO> response = this.restTemplate.getForEntity(BASE_ACTIVITY_URL, ActivityDTO.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return modelMapper.map(response.getBody(), Activity.class);
        } else {
            return null;
        }
    }
}
