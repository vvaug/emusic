package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyCategoriesClient;
import br.com.vvaug.spotifyutils.gateway.GetSeveralCategoriesGateway;
import br.com.vvaug.spotifyutils.response.SeveralCategoriesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSeveralCategoriesGatewayImpl implements GetSeveralCategoriesGateway{
	
	private final SpotifyCategoriesClient spotifyCategoriesClient;

	@Override
	public SeveralCategoriesResponse getCategories(String authorization) {
		return spotifyCategoriesClient.getCategories(authorization);
	}
	

}
