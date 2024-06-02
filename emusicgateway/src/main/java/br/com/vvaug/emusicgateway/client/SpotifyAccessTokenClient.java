package br.com.vvaug.emusicgateway.client;


import br.com.vvaug.emusicgateway.config.FeignConfiguration;
import br.com.vvaug.emusicgateway.dto.SignInResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@FeignClient(name = "spotify-get-access-token-client", url = "${feign.spotify.access-token.url}", configuration = FeignConfiguration.class)
public interface SpotifyAccessTokenClient {

     @PostMapping(consumes = APPLICATION_FORM_URLENCODED_VALUE)
     SignInResponse getAccessToken(@RequestParam("client_id") String clientId,
                                   @RequestParam("client_secret") String secretId,
                                   @RequestParam("grant_type") String grantType);
}
