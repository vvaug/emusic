package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.request.SigInRequest;
import br.com.vvaug.spotifyutils.response.SignInResponse;
import br.com.vvaug.spotifyutils.usecase.SignInUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign-in")
@RequiredArgsConstructor
public class SignInResource {

    private final SignInUseCase signInUseCase;
    @PostMapping
    public SignInResponse login() {
        return signInUseCase.execute();
    }
}
