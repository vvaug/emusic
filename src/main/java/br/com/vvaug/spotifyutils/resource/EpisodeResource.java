package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.EpisodeResponse;
import br.com.vvaug.spotifyutils.response.SeveralEpisodesResponse;
import br.com.vvaug.spotifyutils.usecase.GetEpisodeUseCase;
import br.com.vvaug.spotifyutils.usecase.GetSeveralEpisodesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/episodes")
@RequiredArgsConstructor
public class EpisodeResource {
	
	private final GetEpisodeUseCase getEpisodeUseCase;
	private final GetSeveralEpisodesUseCase getSeveralEpisodesUseCase;
	
	@GetMapping("/{id}")
	public EpisodeResponse getEpisode(@PathVariable("id") String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
		return getEpisodeUseCase.execute(id, authorization);
	}
	@GetMapping
	public SeveralEpisodesResponse getSeveralEpisodes(@RequestParam("ids") String ids, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
		return getSeveralEpisodesUseCase.execute(ids, authorization);
	}

}
