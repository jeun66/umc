package com.example.chapter6.dto;

// 가게 및 별점대 필터를 위한 DTO
public record ReviewFilter(
        Long restaurantId,      // 선택된 가게 id
        String restaurantName,  // 가게명으로 검색
        Integer starGrade       // 5, 4, 3... 등 별점대
) {}
