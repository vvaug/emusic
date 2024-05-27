package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.MarketsResponse;

public interface GetMarketsGateway {
	
	MarketsResponse getMarkets( String authorization);

}
