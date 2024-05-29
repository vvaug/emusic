package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.AlbumTracksResponse;

public interface GetAlbumTracksUseCase {

    AlbumTracksResponse execute(String id, String authorization);
}
