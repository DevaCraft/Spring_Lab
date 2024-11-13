package com.pdp.oidc.oidc_lab.controller;

import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.server.ServerErrorException;

import java.io.IOException;

import static org.springframework.http.HttpStatus.*;

public class CustomResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        // Check if the status code represents an error (4xx or 5xx)
        return response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError();
    }

    @SneakyThrows
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatusCode statusCode = response.getStatusCode();

        // Customize behavior based on status code
        if (statusCode.is4xxClientError()) {
            // Handle 4xx errors
            switch (statusCode) {
                case BAD_REQUEST:
                    // Custom logic for 400 Bad Request
                    throw new BadRequestException("Bad request - invalid parameters.");
                case UNAUTHORIZED:
                    // Custom logic for 401 Unauthorized
                    try {
                        throw new UnauthorizedException("Unauthorized - invalid credentials.");
                    } catch (UnauthorizedException e) {
                        throw new RuntimeException(e);
                    }
                case FORBIDDEN:
                    // Custom logic for 403 Forbidden
                    throw new ForbiddenException("Forbidden - access denied.");
                case NOT_FOUND:
                    // Custom logic for 404 Not Found
                    throw new ResourceNotFoundException("Resource not found.");
                default:
                    throw new ClientErrorException("Client error: " + statusCode);
            }
        } else if (statusCode.is5xxServerError()) {
            // Handle 5xx errors
            throw new RuntimeException();
        }
    }
}
