package com.example.chapter6.api;

import com.example.chapter6.dto.ReviewFilter;
import com.example.chapter6.dto.ReviewMyItem;
import com.example.chapter6.service.ReviewReadService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewReadService reviewReadService;

    @GetMapping("/me")
    public ApiResponse<Page<ReviewMyItem>> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) Long restaurantId,
            @RequestParam(required = false) String restaurantName,
            @RequestParam(required = false) Integer starGrade,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var filter = new ReviewFilter(restaurantId, restaurantName, starGrade);
        Page<ReviewMyItem> result = reviewReadService.getMyReviews(memberId, filter, page, size);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, result);
    }
}

