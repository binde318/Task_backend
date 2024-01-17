package com.binde.Backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class BookApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

}
