package com.example.chapter6.controller;

import com.example.chapter6.api.ApiResponse;
import com.example.chapter6.dto.ReviewCreateRequest;
import com.example.chapter6.dto.ReviewCreateResponse;
import com.example.chapter6.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private static final Long HARD_CODED_MEMBER_ID = 1L; // DB에 있는 유저 ID로 맞추기

    @PostMapping
    public ApiResponse<ReviewCreateResponse> createReview(
            @RequestBody ReviewCreateRequest request
    ) {
        ReviewCreateResponse response =
                reviewService.createReview(HARD_CODED_MEMBER_ID, request);
        return ApiResponse.onSuccess(response);
    }
}
