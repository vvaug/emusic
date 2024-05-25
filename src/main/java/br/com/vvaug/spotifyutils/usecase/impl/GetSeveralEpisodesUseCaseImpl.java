package br.com.vvaug.spotifyutils.usecase.impl;

import org.springframework.stereotype.Service;

import br.com.vvaug.spotifyutils.gateway.GetSeveralEpisodesGateway;
import br.com.vvaug.spotifyutils.response.SeveralEpisodesResponse;
import br.com.vvaug.spotifyutils.usecase.GetSeveralEpisodesUseCase;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetSeveralEpisodesUseCaseImpl implements GetSeveralEpisodesUseCase{
	
	private final GetSeveralEpisodesGateway getSeveralEpisodesGateway;
	
	@Override
	public SeveralEpisodesResponse execute(String ids, String authorization) {
		return getSeveralEpisodesGateway.getSeveralEpisodes(ids, authorization);
	}

	

}
