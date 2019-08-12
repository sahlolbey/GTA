package com.gta.outage.service;

public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);
}
