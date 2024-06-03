package br.com.vvaug.emusicuserds.exception.handler;

import br.com.vvaug.emusicuserds.exception.ApplicationException;
import br.com.vvaug.emusicuserds.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException ex){
        log.error("An error occurred: {}", ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus())
                .body(ErrorResponse.builder()
                .message(ex.getMessage())
                .statusCode(String.valueOf(ex.getHttpStatus().value()))
                .build());
    }
}
