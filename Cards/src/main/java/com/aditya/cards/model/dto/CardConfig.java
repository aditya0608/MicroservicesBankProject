package com.aditya.cards.model.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "cards")
public record CardConfig(String message, Map<String,String> contact, List<String> phoneNumbers) {
}
