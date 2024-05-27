package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.EpisodeResponse;

public interface GetEpisodeGateway {
	
	EpisodeResponse getEpisode(String id,String authorization);

}
