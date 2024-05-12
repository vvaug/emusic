package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.AlbumResponse;

public interface GetArtistAlbumGateway {

    public AlbumResponse getArtistAlbum(String id, String authorization);
}
