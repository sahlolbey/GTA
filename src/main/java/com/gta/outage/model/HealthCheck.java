package com.gta.outage.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This model entity added just to check database connection status
 * No data will be saved for this entity
 */
@Entity
public class HealthCheck {
    @Id
    private Long id;
}
