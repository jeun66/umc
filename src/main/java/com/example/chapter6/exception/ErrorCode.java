package com.example.chapter6.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    REGION_NOT_FOUND("REGION_404", "지역을 찾을 수 없습니다."),
    RESTAURANT_NOT_FOUND("RESTAURANT_404", "식당을 찾을 수 없습니다."),
    REVIEW_NOT_FOUND("REVIEW_404", "리뷰를 찾을 수 없습니다."),
    MISSION_NOT_FOUND("MISSION_404", "미션을 찾을 수 없습니다."),
    MEMBER_NOT_FOUND("MEMBER_404", "유저를 찾을 수 없습니다."),
    MEMBERMISSION_NOT_FOUND("MEMBERMISSION_404", "미션 도전 기록을 찾을 수 없습니다.");

    private final String code;
    private final String message;
}
