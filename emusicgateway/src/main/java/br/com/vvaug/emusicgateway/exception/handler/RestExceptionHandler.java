package br.com.vvaug.emusicgateway.exception.handler;

import br.com.vvaug.emusicgateway.dto.ErrorResponse;
import br.com.vvaug.emusicgateway.exception.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleJoseException(ApplicationException ex){
        return ResponseEntity.badRequest().body(
                ErrorResponse.builder()
                .message(ex.getMessage())
                .statusCode(ex.getHttpStatus().value())
                .build());
    }
}
