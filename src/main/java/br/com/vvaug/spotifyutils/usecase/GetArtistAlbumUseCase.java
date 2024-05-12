package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.AlbumResponse;

public interface GetArtistAlbumUseCase {

    AlbumResponse execute(String id, String authorization);
}
