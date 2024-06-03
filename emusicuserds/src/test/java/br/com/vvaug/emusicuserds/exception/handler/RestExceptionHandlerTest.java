package br.com.vvaug.emusicuserds.exception.handler;

import br.com.vvaug.emusicuserds.exception.ApplicationException;
import br.com.vvaug.emusicuserds.response.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RestExceptionHandlerTest {

    private final RestExceptionHandler handler = new RestExceptionHandler();

    @Test
    void handleApplicationExceptionTest(){
        String message = "User not found.";
        ApplicationException applicationException = new ApplicationException(HttpStatus.NOT_FOUND, message);
        ResponseEntity<ErrorResponse> response = handler.handleApplicationException(applicationException);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(message, Objects.requireNonNull(response.getBody()).getMessage());
    }

}