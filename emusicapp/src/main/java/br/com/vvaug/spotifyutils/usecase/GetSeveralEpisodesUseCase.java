package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.SeveralEpisodesResponse;

public interface GetSeveralEpisodesUseCase {
	
	SeveralEpisodesResponse execute(String ids, String authorization);

}
