package br.com.vvaug.spotifyutils.resource;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vvaug.spotifyutils.response.GenresResponse;
import br.com.vvaug.spotifyutils.usecase.GetGenresUseCase;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/available-genre-seeds")
@RequiredArgsConstructor

public class GenresResource {
	
	private final GetGenresUseCase getGenresUseCase;
	
	@GetMapping
	public GenresResponse getGenre(@RequestHeader (HttpHeaders.AUTHORIZATION) String authorization) {
		return getGenresUseCase.execute(authorization);
	}

}
