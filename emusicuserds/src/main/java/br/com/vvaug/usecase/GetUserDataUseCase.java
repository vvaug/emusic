package br.com.vvaug.usecase;

import br.com.vvaug.request.GetUserDataRequest;
import br.com.vvaug.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface GetUserDataUseCase {


    ResponseEntity<UserResponse> execute (GetUserDataRequest request);
}
