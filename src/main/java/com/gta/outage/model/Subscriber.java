package com.gta.outage.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public @Data
class Subscriber {


    private String name;
    @Id
    private String email;

}
