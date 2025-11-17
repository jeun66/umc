package com.example.chapter6.apiPayload.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode {
    OK("S200", "요청이 성공했습니다."),
    CREATED("S201", "정상적으로 생성되었습니다."),
    UPDATED("S200U", "정상적으로 수정되었습니다."),
    DELETED("S200D", "정상적으로 삭제되었습니다.");

    private final String code;
    private final String message;
}
