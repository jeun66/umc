package com.example.chapter6.controller;

import com.example.chapter6.api.ApiResponse;
import com.example.chapter6.dto.RestaurantCreateRequest;
import com.example.chapter6.dto.RestaurantCreateResponse;
import com.example.chapter6.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RestaurantController {   // ← 클래스 맞아요!

    private final RestaurantService restaurantService;

    @PostMapping("/regions/{regionId}/restaurants")
    public ApiResponse<RestaurantCreateResponse> createRestaurant(
            @PathVariable Long regionId,
            @RequestBody RestaurantCreateRequest request
    ) {
        RestaurantCreateResponse response =
                restaurantService.createRestaurant(regionId, request);
        return ApiResponse.onSuccess(response);
    }
}
