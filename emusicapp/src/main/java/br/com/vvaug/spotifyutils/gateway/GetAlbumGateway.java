package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.AlbumResponse;

public interface GetAlbumGateway {

    AlbumResponse getAlbum(String id, String authorization);
}
