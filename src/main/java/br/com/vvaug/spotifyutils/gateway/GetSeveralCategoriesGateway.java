package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.SeveralCategoriesResponse;

public interface GetSeveralCategoriesGateway {
	
	SeveralCategoriesResponse getCategories(String authorization);

}
