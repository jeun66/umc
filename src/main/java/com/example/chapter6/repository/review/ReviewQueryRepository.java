package com.example.chapter6.repository.review;

import com.example.chapter6.dto.ReviewFilter;
import com.example.chapter6.dto.ReviewMyItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewQueryRepository {
    Page<ReviewMyItem> findMyReviews(Long memberId, ReviewFilter filter, Pageable pageable);
}
