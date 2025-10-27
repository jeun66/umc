package com.example.chapter5.dto;

import java.time.LocalDate;

public record MissionHomeItem(
        Long missionId,
        String restaurantName,
        String category,
        String condition,
        Integer point,
        LocalDate deadline
) {}
