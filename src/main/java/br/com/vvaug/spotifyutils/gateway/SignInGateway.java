package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.SignInResponse;

public interface SignInGateway {

    SignInResponse execute(String secretId, String clientId, String grant_type);
}
