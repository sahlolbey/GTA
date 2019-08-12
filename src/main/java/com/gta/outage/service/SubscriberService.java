package com.gta.outage.service;

import com.gta.outage.model.Subscriber;

import java.util.List;


public interface SubscriberService {

    void addSubscriber(Subscriber subscriber);

    List<Subscriber> getAllSubscribers();
}
