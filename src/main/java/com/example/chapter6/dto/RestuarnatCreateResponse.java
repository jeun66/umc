// RestaurantCreateResponse.java
package com.example.chapter6.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestaurantCreateResponse {
    private Long restaurantId;
    private String name;
}
