package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetGenresGateway;
import br.com.vvaug.spotifyutils.response.GenresResponse;
import br.com.vvaug.spotifyutils.usecase.GetGenresUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class GetGenresUseCaseImpl implements GetGenresUseCase{
	
	private final GetGenresGateway getGenresGateway;

	@Override
	public GenresResponse execute(String authorization) {
		return getGenresGateway.getGenres(authorization);
	}
	

}
