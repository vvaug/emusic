package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetSingleCategoryGateway;
import br.com.vvaug.spotifyutils.response.CategoriesItemResponse;
import br.com.vvaug.spotifyutils.usecase.GetSingleCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class GetSingleCategoryUseCaseImpl implements GetSingleCategoryUseCase{
	
	private final GetSingleCategoryGateway getSingleCategoryGateway;

	@Override
	public CategoriesItemResponse execute(String id, String authorization) {
		return getSingleCategoryGateway.getSingleCategory(id, authorization);
	}
	
	

}
