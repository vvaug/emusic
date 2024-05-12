package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.ArtistAlbumResponse;

public interface GetArtistAlbumUseCase {

    ArtistAlbumResponse execute(String id, String authorization);
}
