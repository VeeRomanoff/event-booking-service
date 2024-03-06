package com.dolphin.locationsservice.api.exception;

import java.time.LocalDateTime;

public class ErrorMessageDto {
    private final String message;
    private final String detailedMessage;
    private final LocalDateTime time;

    public ErrorMessageDto(String message, String detailedMessage, LocalDateTime time) {
        this.message = message;
        this.detailedMessage = detailedMessage;
        this.time = time;
    }
}
