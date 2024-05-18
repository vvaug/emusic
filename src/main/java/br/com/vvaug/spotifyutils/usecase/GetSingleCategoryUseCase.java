package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.CategoriesItemResponse;

public interface GetSingleCategoryUseCase {
	
	CategoriesItemResponse execute(String id, String authorization);

}
