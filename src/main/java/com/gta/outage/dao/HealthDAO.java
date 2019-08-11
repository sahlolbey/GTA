package com.gta.outage.dao;

import com.gta.outage.model.HealthCheck;
import org.springframework.data.repository.CrudRepository;

public interface HealthDAO extends CrudRepository<HealthCheck, Long> {

}
