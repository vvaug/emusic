package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.SignInGateway;
import br.com.vvaug.spotifyutils.response.SignInResponse;
import br.com.vvaug.spotifyutils.usecase.SignInUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInUseCaseImpl implements SignInUseCase {

    private final SignInGateway signInGateway;
    @Value("${spotify.secret-id}")
    private String secretId;
    @Value("${spotify.client-id}")
    private String clientId;
    @Value("${spotify.grant-type}")
    private String grantType;
    @Override
    public SignInResponse execute() {
        return signInGateway.execute(secretId, clientId, grantType);
    }

}
