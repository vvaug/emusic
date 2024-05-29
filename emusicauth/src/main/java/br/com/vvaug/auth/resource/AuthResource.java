package br.com.vvaug.auth.resource;

import br.com.vvaug.auth.request.AuthRequest;
import br.com.vvaug.auth.response.AuthResponse;
import br.com.vvaug.auth.usecase.AuthenticationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthResource {

    private final AuthenticationUseCase authenticationUseCase;

    @PostMapping
    public AuthResponse auth(@RequestBody AuthRequest authRequest){
        return authenticationUseCase.execute(authRequest);
    }
}
