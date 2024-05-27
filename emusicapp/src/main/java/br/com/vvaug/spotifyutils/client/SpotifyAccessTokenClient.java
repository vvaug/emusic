package br.com.vvaug.spotifyutils.client;


import br.com.vvaug.spotifyutils.response.SignInResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@FeignClient(name = "spotify-get-access-token-client", url = "${feign.spotify.access-token.url}")
public interface SpotifyAccessTokenClient {

     @PostMapping(consumes = APPLICATION_FORM_URLENCODED_VALUE)
     SignInResponse getAccessToken(@RequestParam("client_id") String clientId,
                                    @RequestParam("client_secret") String secretId,
                                    @RequestParam("grant_type") String grantType);
}
