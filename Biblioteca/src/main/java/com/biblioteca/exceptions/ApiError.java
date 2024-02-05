package com.biblioteca.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {

    private int statusCode;
    private String error;
    private LocalDateTime timeStamp;
}
