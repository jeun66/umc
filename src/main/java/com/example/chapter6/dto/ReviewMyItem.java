package com.example.chapter6.dto;

import java.time.LocalDateTime;

// 내가 작성한 리뷰 1개를 보여주는 DTO
public record ReviewMyItem(
        Long id,
        String restaurantName,
        String content,
        Double star,
        String reply,
        LocalDateTime createdAt
) {}
