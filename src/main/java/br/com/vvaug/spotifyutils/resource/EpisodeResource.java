package br.com.vvaug.spotifyutils.resource;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vvaug.spotifyutils.response.EpisodeResponse;
import br.com.vvaug.spotifyutils.response.SeveralEpisodesResponse;
import br.com.vvaug.spotifyutils.usecase.GetEpisodeUseCase;
import br.com.vvaug.spotifyutils.usecase.GetSeveralEpisodesUseCase;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/episodes")
@RequiredArgsConstructor

public class EpisodeResource {
	
	private final GetEpisodeUseCase getEpisodeUseCase;
	private final GetSeveralEpisodesUseCase getSeveralEpisodesUseCase;
	
	@GetMapping("/{id}")
	public EpisodeResponse getEpisode(@PathVariable("id") String id,@RequestHeader (HttpHeaders.AUTHORIZATION) String authorization) {
		return getEpisodeUseCase.execute(id,authorization);
	}
	@GetMapping
	public SeveralEpisodesResponse getSeveralEpisodes(@RequestParam ("ids") String ids, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
		return getSeveralEpisodesUseCase.execute(ids, authorization);
	}

}
