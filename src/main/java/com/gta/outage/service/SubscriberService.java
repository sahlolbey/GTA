package com.gta.outage.service;

import com.gta.outage.dao.SubscriberDAO;
import com.gta.outage.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriberService {
    private final SubscriberDAO subscriberDAO;

    @Autowired
    public SubscriberService(SubscriberDAO subscriberDAO) {
        this.subscriberDAO = subscriberDAO;
    }

    public void addSubscriber(Subscriber subscriber) {
        try {
            subscriberDAO.save(subscriber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Subscriber> getAllSubscribers() {
        List<Subscriber> subscribers = new ArrayList<>();
        subscriberDAO.findAll().forEach(subscribers::add);
        return subscribers;
    }
}
