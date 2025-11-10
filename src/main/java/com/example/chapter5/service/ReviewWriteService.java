package com.example.chapter5.service;

import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.domain.restaurant.entity.Restaurant;
import com.example.chapter4.domain.review.entity.Review;
import com.example.chapter5.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewWriteController {

    private final ReviewWriteService reviewWriteService;

    @PostMapping
    public ApiResponse<Long> write(
            @RequestParam Long userId,
            @RequestParam Long restaurantId,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam int rate
    ) {
        Long id = reviewWriteService.writeReview(
                userId, restaurantId, title, content, rate, LocalDateTime.now()
        );
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, id);
    }
}

