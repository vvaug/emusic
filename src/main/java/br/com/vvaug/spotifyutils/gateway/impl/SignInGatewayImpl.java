package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAccessTokenClient;
import br.com.vvaug.spotifyutils.gateway.SignInGateway;
import br.com.vvaug.spotifyutils.response.SignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInGatewayImpl implements SignInGateway {

    private final SpotifyAccessTokenClient spotifyAccessTokenClient;
    @Override
    public SignInResponse execute(String secretId, String clientId, String grant_type) {
        return spotifyAccessTokenClient.getAccessToken(clientId, secretId, grant_type);
    }
}
