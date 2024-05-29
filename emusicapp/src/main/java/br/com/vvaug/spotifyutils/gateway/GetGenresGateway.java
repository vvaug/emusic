package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.GenresResponse;

public interface GetGenresGateway {
	
	GenresResponse getGenres(String authorization);

}
