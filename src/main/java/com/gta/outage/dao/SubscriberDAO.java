package com.gta.outage.dao;

import com.gta.outage.model.Subscriber;
import org.springframework.data.repository.CrudRepository;

public interface SubscriberDAO extends CrudRepository<Subscriber, String> {
}
