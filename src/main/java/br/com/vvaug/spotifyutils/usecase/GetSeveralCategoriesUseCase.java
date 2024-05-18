package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.SeveralCategoriesResponse;

public interface GetSeveralCategoriesUseCase {
	
	SeveralCategoriesResponse execute (String authorization);

}
