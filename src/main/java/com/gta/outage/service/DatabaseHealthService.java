package com.gta.outage.service;

import com.gta.outage.dao.HealthDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * This a service to check database availability periodically
 */
@EnableScheduling
@Service
public class DatabaseHealthService {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseHealthService.class);
    @Autowired
    HealthDAO healthDAO;

    /**
     * This method scheduled to periodically query database to see if  the
     * connection is available
     */
    @Scheduled(fixedDelay = 1000)
    private void isDatabaseUp() {
        logger.info("isDatabaseUp started");
        healthDAO.findById(1L);
        logger.info("isDatabaseUp ended");

    }
}
