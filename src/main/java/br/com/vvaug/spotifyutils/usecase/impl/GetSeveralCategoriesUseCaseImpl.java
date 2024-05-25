package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetSeveralCategoriesGateway;
import br.com.vvaug.spotifyutils.response.SeveralCategoriesResponse;
import br.com.vvaug.spotifyutils.usecase.GetSeveralCategoriesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSeveralCategoriesUseCaseImpl implements GetSeveralCategoriesUseCase{
	
	private final GetSeveralCategoriesGateway getSeveralCategoriesGateway;
	@Override
	public SeveralCategoriesResponse execute(String authorization) {
		return getSeveralCategoriesGateway.getCategories(authorization);
	}

}
