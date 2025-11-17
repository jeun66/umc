// MissionChallengeResponse.java
package com.example.chapter6.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionChallengeResponse {
    private Long memberMissionId;
    private Long missionId;
    private Long memberId;
    private String status;
}
