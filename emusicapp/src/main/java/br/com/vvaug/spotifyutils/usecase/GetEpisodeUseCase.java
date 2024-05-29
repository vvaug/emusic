package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.EpisodeResponse;

public interface GetEpisodeUseCase {
	
	EpisodeResponse execute(String id,String authorization);

}
