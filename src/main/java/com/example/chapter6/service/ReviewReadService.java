package com.example.chapter6.service;

import com.example.chapter6.dto.ReviewFilter;
import com.example.chapter6.dto.ReviewMyItem;
import com.example.chapter6.repository.review.ReviewQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewReadService {

    private final ReviewQueryRepository reviewQueryRepository;

    public Page<ReviewMyItem> getMyReviews(Long memberId,
                                           ReviewFilter filter,
                                           int page,
                                           int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        return reviewQueryRepository.findMyReviews(memberId, filter, pageable);
    }
}

