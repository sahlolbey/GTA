package com.gta.outage.rest;

import com.gta.outage.model.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupAPIController {
    private static final Logger logger = LoggerFactory.getLogger(SignupAPIController.class);

    @RequestMapping("/api/addSubscriber")
    public ResponseEntity<String> addSubscriber(Subscriber subscriber) {
        logger.info("addSubscriber called");
        return ResponseEntity.ok().body("successfully created");
    }

}
