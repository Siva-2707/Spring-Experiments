package com.siva.socialmediaapp.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDetail {

    private LocalDateTime timestamp;
    private String message;
    private String details;

}
