package com.example.chapter5.service;

import com.example.chapter4.domain.member.entity.User;
import com.example.chapter4.domain.restaurant.entity.Restaurant;
import com.example.chapter4.domain.review.entity.Review;
import com.example.chapter5.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewWriteService {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public Long writeReview(Long userId,
                            Long restaurantId,
                            String title,
                            String content,
                            int rate,
                            LocalDateTime now) {

        User user = userRepository.lockById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found: " + userId));

        Restaurant restaurant = restaurantRepository.lockById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("restaurant not found: " + restaurantId));

        Review review = Review.builder()
                .user(user)
                .restaurant(restaurant)
                .title(title)
                .content(content)
                .rate(rate)
                .createdAt(now)
                .updatedAt(now)
                .build();

        return reviewRepository.save(review).getId();
    }
}
