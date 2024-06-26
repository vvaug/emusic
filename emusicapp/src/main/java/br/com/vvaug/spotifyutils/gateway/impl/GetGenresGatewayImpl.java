package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyGenresClient;
import br.com.vvaug.spotifyutils.gateway.GetGenresGateway;
import br.com.vvaug.spotifyutils.response.GenresResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetGenresGatewayImpl implements GetGenresGateway{
	
	private final SpotifyGenresClient spotifyGenresClient;

	@Override
	public GenresResponse getGenres(String authorization) {
		return spotifyGenresClient.getGenres(authorization);
	}
	
	

}
