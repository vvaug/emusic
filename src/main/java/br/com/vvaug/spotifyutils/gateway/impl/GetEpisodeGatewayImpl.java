package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyEpisodeClient;
import br.com.vvaug.spotifyutils.gateway.GetEpisodeGateway;
import br.com.vvaug.spotifyutils.response.EpisodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetEpisodeGatewayImpl implements GetEpisodeGateway{
	
	private final SpotifyEpisodeClient spotifyEpisodeClient;
	
	@Override
	public EpisodeResponse getEpisode(String id, String authorization) {
		return spotifyEpisodeClient.getEpisode(id, authorization);
	}

}
