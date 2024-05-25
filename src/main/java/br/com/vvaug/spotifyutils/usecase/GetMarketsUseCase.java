package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.MarketsResponse;

public interface GetMarketsUseCase {
	
	MarketsResponse execute(String authorization);

}
