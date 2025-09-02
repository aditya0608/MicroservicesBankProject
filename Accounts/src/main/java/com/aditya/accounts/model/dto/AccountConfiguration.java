package com.aditya.accounts.model.dto;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "accounts")
public record AccountConfiguration (String message, Map<String,String> contact, List<String> phoneNumbers){
}
