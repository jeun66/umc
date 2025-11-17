// ReviewCreateRequest.java
package com.example.chapter6.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewCreateRequest {
    private Long restaurantId;
    private int rating;
    private String content;
}
