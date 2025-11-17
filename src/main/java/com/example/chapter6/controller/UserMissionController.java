package com.example.chapter6.controller;

import com.example.chapter6.api.ApiResponse;
import com.example.chapter6.dto.MissionChallengeRequest;
import com.example.chapter6.dto.MissionChallengeResponse;
import com.example.chapter6.service.MemberMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/me/missions")
public class UserMissionController {

    private final MemberMissionService memberMissionService;
    private static final Long HARD_CODED_MEMBER_ID = 1L;

    @PostMapping
    public ApiResponse<MissionChallengeResponse> challengeMission(
            @RequestBody MissionChallengeRequest request
    ) {
        MissionChallengeResponse response =
                memberMissionService.startChallenge(HARD_CODED_MEMBER_ID, request.getMissionId());
        return ApiResponse.onSuccess(response);
    }
}

