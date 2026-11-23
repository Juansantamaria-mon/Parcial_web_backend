package com.bodegas.dto;

import java.time.Instant;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {

    private String code;
    private String message;
    private Instant timestamp = Instant.now();
    private List<String> details;

    public ErrorDto(String code, String message, List<String> details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }

    public ErrorDto(String code, String message) {
        this(code, message, List.of());
    }
}
