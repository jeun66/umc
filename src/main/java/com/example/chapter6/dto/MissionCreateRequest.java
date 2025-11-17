// MissionCreateRequest.java
package com.example.chapter6.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MissionCreateRequest {
    private String title;
    private String description;
    private int rewardPoint;
}
