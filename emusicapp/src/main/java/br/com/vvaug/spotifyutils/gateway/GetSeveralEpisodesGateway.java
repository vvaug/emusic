package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.SeveralEpisodesResponse;

public interface GetSeveralEpisodesGateway {
	
	SeveralEpisodesResponse getSeveralEpisodes( String ids, String authorization);

}
