package br.com.vvaug.spotifyutils.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.vvaug.spotifyutils.response.EpisodeResponse;
import br.com.vvaug.spotifyutils.response.SeveralEpisodesResponse;

@FeignClient(name = "spotify-get-episodes-client",url = "${feign.spotify.episodes.url}")
public interface SpotifyEpisodeClient {
	
	@GetMapping("/{id}")
	EpisodeResponse getEpisode(@PathVariable("id") String id,@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);
	
	@GetMapping
	SeveralEpisodesResponse getSeveralEpisodes(@RequestParam("ids") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);

}
