package com.biblioteca.Exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {
    private int statusCode;
    private String error;
    private LocalDateTime timeStamp;
}
