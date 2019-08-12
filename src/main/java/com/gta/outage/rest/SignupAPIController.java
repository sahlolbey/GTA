package com.gta.outage.rest;

import com.gta.outage.model.Subscriber;
import com.gta.outage.service.SubscriberServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupAPIController {
    private static final Logger logger = LoggerFactory.getLogger(SignupAPIController.class);

    private final SubscriberServiceImp subscriberServiceImp;

    @Autowired
    public SignupAPIController(SubscriberServiceImp subscriberServiceImp) {
        this.subscriberServiceImp = subscriberServiceImp;
    }

    @RequestMapping("/api/addSubscriber")
    public ResponseEntity<String> addSubscriber(@RequestBody Subscriber subscriber) {
        logger.info("addSubscriber called");
        logger.info("name=" + subscriber.getName());
        logger.info("email=" + subscriber.getEmail());
        subscriberServiceImp.addSubscriber(subscriber);
        return ResponseEntity.ok().body("successfully created");
    }

}
