package br.com.vvaug.exception.handler;

import br.com.vvaug.exception.ApplicationException;
import br.com.vvaug.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleApplicationException(ApplicationException ex){
        log.error("An error occurred: {}", ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus())
                .body(ErrorResponse.builder()
                .message(ex.getMessage())
                .statusCode(String.valueOf(ex.getHttpStatus().value()))
                .build());
    }
}
