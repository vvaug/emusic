package br.com.vvaug.emusicregister.resource;

import br.com.vvaug.emusicregister.request.CreateUserRequest;
import br.com.vvaug.emusicregister.response.UserResponse;
import br.com.vvaug.emusicregister.usecase.RegisterNewUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterResource {

    private final RegisterNewUserUseCase registerNewUserUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse registerNewUser(@RequestBody CreateUserRequest createUserRequest){
        return registerNewUserUseCase.execute(createUserRequest);
    }
}
