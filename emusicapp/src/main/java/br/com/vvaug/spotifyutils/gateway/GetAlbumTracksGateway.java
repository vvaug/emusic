package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.AlbumTracksResponse;

public interface GetAlbumTracksGateway {

    AlbumTracksResponse getAlbumTracks(String id, String authorization);
}
