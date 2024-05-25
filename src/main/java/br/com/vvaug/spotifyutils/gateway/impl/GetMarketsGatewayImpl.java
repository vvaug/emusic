package br.com.vvaug.spotifyutils.gateway.impl;

import org.springframework.stereotype.Service;

import br.com.vvaug.spotifyutils.client.SpotifyMarketsClient;
import br.com.vvaug.spotifyutils.gateway.GetMarketsGateway;
import br.com.vvaug.spotifyutils.response.MarketsResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class GetMarketsGatewayImpl implements GetMarketsGateway{
	
	private final SpotifyMarketsClient spotifyMarketsClient;

	@Override
	public MarketsResponse getMarkets(String authorization) {
		return spotifyMarketsClient.getMarkets(authorization);
	}
	
	

}
