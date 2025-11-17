package com.example.chapter6.controller;

import com.example.chapter6.api.ApiResponse;
import com.example.chapter6.dto.MissionCreateRequest;
import com.example.chapter6.dto.MissionCreateResponse;
import com.example.chapter6.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/restaurants/{restaurantId}/missions")
    public ApiResponse<MissionCreateResponse> createMission(
            @PathVariable Long restaurantId,
            @RequestBody MissionCreateRequest request
    ) {
        MissionCreateResponse response =
                missionService.createMission(restaurantId, request);
        return ApiResponse.onSuccess(response);
    }
}

