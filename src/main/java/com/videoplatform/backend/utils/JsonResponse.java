package com.videoplatform.backend.utils;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class JsonResponse {
	public static String createErrorResponse(HttpStatus status, String errorMessage, String requestURI) {
        LocalDateTime timestamp = LocalDateTime.now();
        return "{\n" +
                "    \"timestamp\": \"" + timestamp + "\",\n" +
                "    \"status\": " + status.value() + ",\n" +
                "    \"error\": \"" + status.toString() + "\",\n" +
                "    \"message\": \"" + errorMessage + "\",\n" +
                "    \"path\": \"" + requestURI + "\"\n" +
                "}";
    }
	
}
