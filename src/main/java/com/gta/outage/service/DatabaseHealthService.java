package com.gta.outage.service;

import com.gta.outage.model.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This a service to check database availability periodically
 */
@EnableScheduling
@Service
public class DatabaseHealthService implements HealthCheckService {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseHealthService.class);

    /* a component of Spring actuator that reports application health */
    private final HealthEndpoint healthEndpoint;
    private final SubscriberServiceImp subscriberServiceImp;
    private final EmailServiceImp emailServiceImp;
    private List<Subscriber> subscriberList;
    // this variable is flag to prevent reapititive alert
    private boolean alertSent = false;

    @Autowired
    public DatabaseHealthService(HealthEndpoint healthEndpoint, SubscriberServiceImp subscriberServiceImp, EmailServiceImp emailServiceImp) {
        this.healthEndpoint = healthEndpoint;
        this.subscriberServiceImp = subscriberServiceImp;
        this.emailServiceImp = emailServiceImp;
    }

    /**
     * This method scheduled to periodically db health status
     */
    @Scheduled(fixedDelay = 5000)
    public void isServiceUp() {
        logger.info("isDatabaseUp started");

        String status = healthEndpoint.healthForComponent("db").getStatus().toString();


        if (!status.equalsIgnoreCase("UP")) {

            if (subscriberList != null && !subscriberList.isEmpty() && !alertSent) {
                String error = (String) healthEndpoint.healthForComponent("db").getDetails().get("error");
                subscriberList.forEach((s) -> emailServiceImp.sendSimpleMessage(s.getEmail(),
                        "Database is down",
                        "Hi " + s.getName() +
                                ",\n Database is not up now the error message is \n " + error));
            } else {
                logger.info("subscriber list is empty");
            }
        } else {
            alertSent = false;
        }
        logger.info("isDatabaseUp ended");

    }

    @Scheduled(fixedDelay = 60000)
    private void updateSubscribersList() {
        subscriberList = subscriberServiceImp.getAllSubscribers();
    }

}
