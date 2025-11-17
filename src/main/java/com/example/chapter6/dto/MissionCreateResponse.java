// MissionCreateResponse.java
package com.example.chapter6.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionCreateResponse {
    private Long missionId;
    private String title;
}
