package br.com.vvaug.spotifyutils.resource;

import br.com.vvaug.spotifyutils.response.MarketsResponse;
import br.com.vvaug.spotifyutils.usecase.GetMarketsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/markets")
@RequiredArgsConstructor

public class MarketsResource {
	
	private final GetMarketsUseCase getMarketsUseCase;
	
	@GetMapping
	public MarketsResponse getMarkets(@RequestHeader (HttpHeaders.AUTHORIZATION) String authorization) {
		return getMarketsUseCase.execute(authorization);
	}

}
