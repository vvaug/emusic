package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.ArtistAlbumResponse;

public interface GetArtistAlbumGateway {

    ArtistAlbumResponse getArtistAlbum(String id, String authorization);
}
