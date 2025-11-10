package com.example.chapter5.dto;

public record UserMissionSummary(
        String restaurantName,
        String condition,
        Integer point,
        Boolean isComplete
) {}
