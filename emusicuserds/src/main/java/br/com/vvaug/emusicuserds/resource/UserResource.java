package br.com.vvaug.emusicuserds.resource;

import br.com.vvaug.emusicuserds.request.CreateUserRequest;
import br.com.vvaug.emusicuserds.response.UserResponse;
import br.com.vvaug.emusicuserds.usecase.CreateUserUseCase;
import br.com.vvaug.emusicuserds.usecase.GetUserByUsernameUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    private final GetUserByUsernameUseCase getUserByUsernameUseCase;
    private final CreateUserUseCase createUserUseCase;

    @GetMapping("/{username}")
    public UserResponse getUserByUsername(@PathVariable("username") String username){
        return getUserByUsernameUseCase.execute(username);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest createUserRequest){
        return createUserUseCase.execute(createUserRequest);
    }
}
