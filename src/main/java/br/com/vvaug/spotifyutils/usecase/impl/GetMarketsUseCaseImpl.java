package br.com.vvaug.spotifyutils.usecase.impl;

import org.springframework.stereotype.Service;

import br.com.vvaug.spotifyutils.gateway.GetMarketsGateway;
import br.com.vvaug.spotifyutils.response.MarketsResponse;
import br.com.vvaug.spotifyutils.usecase.GetMarketsUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class GetMarketsUseCaseImpl implements GetMarketsUseCase {
	
	private final GetMarketsGateway getMarketsGateway;

	@Override
	public MarketsResponse execute(String authorization) {
		return getMarketsGateway.getMarkets(authorization);
	}
	

}
