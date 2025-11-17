package com.example.chapter6.exception;

import com.example.chapter6.api.ApiResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // CustomException 일괄 처리
    @ExceptionHandler(CustomException.class)
    public ApiResponse<?> handleCustomException(CustomException e) {
        return ApiResponse.onFailure(e.getErrorCode().getCode(), e.getMessage());
    }

    // DTO @Valid 에러 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<?> handleValidException(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return ApiResponse.onFailure("VALID_400", errorMessage);
    }

    // 예상치 못한 에러 처리
    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleUnexpectedException(Exception e) {
        return ApiResponse.onFailure("SERVER_500", "서버 내부 오류가 발생했습니다.");
    }
}
