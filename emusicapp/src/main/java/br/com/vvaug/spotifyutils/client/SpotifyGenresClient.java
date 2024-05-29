package br.com.vvaug.spotifyutils.client;

import br.com.vvaug.spotifyutils.response.GenresResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="spotify-get-genres-client", url="${feign.spotify.genres.url}")
public interface SpotifyGenresClient {
	
	@GetMapping
	GenresResponse getGenres(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

}
