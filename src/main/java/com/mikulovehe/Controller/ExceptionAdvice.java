package com.mikulovehe.Controller;


import com.mikulovehe.pojo.Result;
import jakarta.security.auth.message.AuthException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Result<String>> exceptionHandler(IllegalArgumentException e) {

        // 明确返回 HTTP 400 状态码
        return ResponseEntity.badRequest().body(Result.fail(400, e.getMessage()));
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<Result<String>> exceptionHandler(AuthException e) {
        return ResponseEntity.badRequest().body(Result.fail(401, e.getMessage()));
    }

}
