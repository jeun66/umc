package com.example.chapter6.api;

import com.example.chapter6.dto.ReviewFilter;
import com.example.chapter6.dto.ReviewMyItem;
import com.example.chapter6.service.ReviewReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewReadService reviewReadService;

    // 하나의 API에서 필터 모두 처리
    @GetMapping("/me")
    public Page<ReviewMyItem> getMyReviews(
            @RequestParam Long memberId,                // 로그인한 유저 id
            @RequestParam(required = false) Long restaurantId,
            @RequestParam(required = false) String restaurantName,
            @RequestParam(required = false) Integer starGrade, // 5,4,3...
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var filter = new ReviewFilter(restaurantId, restaurantName, starGrade);
        return reviewReadService.getMyReviews(memberId, filter, page, size);
    }
}
