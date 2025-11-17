// ReviewCreateResponse.java
package com.example.chapter6.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewCreateResponse {
    private Long reviewId;
    private Long restaurantId;
    private int rating;
    private String content;
}
