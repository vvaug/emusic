package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.SignInResponse;

import java.util.Map;

public interface SignInGateway {

    public SignInResponse execute (String secretId, String clientId, String grant_type);
}
