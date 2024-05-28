package br.com.vvaug.exception.handler;

import br.com.vvaug.exception.ApplicationException;
import br.com.vvaug.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleApplicationException(ApplicationException ex){
        return ResponseEntity.status(ex.getHttpStatus())
                .body(ErrorResponse.builder()
                .message(ex.getMessage())
                .statusCode(String.valueOf(ex.getHttpStatus().value()))
                .build());
    }
}
