package com.gta.outage.service;

import com.gta.outage.dao.SubscriberDAO;
import com.gta.outage.model.Subscriber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriberServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(SubscriberServiceTest.class);
    @Autowired
    SubscriberService subscriberService;
    @Autowired
    SubscriberDAO subscriberDAO;

    @Test
    public void addSubscriber() {
        logger.info("Test: addSubscriber");
        Subscriber subscriber = new Subscriber();
        subscriber.setEmail("sahlolbey@gmail.com");
        subscriber.setName("Hamid");
        subscriberService.addSubscriber(subscriber);

        Optional<Subscriber> subscriberRetrieved =
                subscriberDAO.findById(subscriber.getEmail());

        Assert.notNull(subscriberRetrieved, "Subscriber not added");
        Assert.isTrue(subscriberRetrieved.isPresent(), "Subscriber not added");
        Assert.isTrue(subscriberRetrieved.get().getName().equals(subscriber.getName()), "Subscriber not added");
    }

    @Test
    public void getAllSubscribers() {
        logger.info("Test: getAllSubscribers");
        Assert.notEmpty(subscriberService.getAllSubscribers(), "No Suscriber loaded");
    }
}