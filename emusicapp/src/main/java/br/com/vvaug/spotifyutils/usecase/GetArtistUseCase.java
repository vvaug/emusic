package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.ArtistResponse;

public interface GetArtistUseCase {

    ArtistResponse execute(String id, String authorization);
}
