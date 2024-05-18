package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.CategoriesItemResponse;

public interface GetSingleCategoryGateway {
	
	CategoriesItemResponse getSingleCategory(String id, String authorization);

}
