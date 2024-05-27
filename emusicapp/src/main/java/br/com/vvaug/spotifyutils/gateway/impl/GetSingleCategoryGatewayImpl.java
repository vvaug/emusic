package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyCategoriesClient;
import br.com.vvaug.spotifyutils.gateway.GetSingleCategoryGateway;
import br.com.vvaug.spotifyutils.response.CategoriesItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSingleCategoryGatewayImpl implements GetSingleCategoryGateway {
	
	private final SpotifyCategoriesClient spotifyCategoriesClient;

	@Override
	public CategoriesItemResponse getSingleCategory(String id, String authorization) {
		return spotifyCategoriesClient.getSingleCategory(id, authorization);
	}
	
	
	
	

}
