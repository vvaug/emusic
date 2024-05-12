package br.com.vvaug.spotifyutils.client;

import br.com.vvaug.spotifyutils.response.ArtistResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "spotify-get-artists-client", url = "${feign.spotify.artists.url}")
public interface GetArtistClient {

    @GetMapping("/{id}")
    public ArtistResponse getArtist(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);
}
