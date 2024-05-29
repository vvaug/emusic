package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.GenresResponse;

public interface GetGenresUseCase {
	
	GenresResponse execute(String authorization);

}
