package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.ArtistTopTracksResponse;

public interface GetArtistTopTracksUseCase {

    ArtistTopTracksResponse execute(String id, String authorization);
}
