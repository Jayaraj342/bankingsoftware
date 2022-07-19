package com.complex.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j(topic = "bean testing")
public class DummyService {

    public String dummyCall() {
        log.info("calling dummy service..");
        return "Success!";
    }
}
