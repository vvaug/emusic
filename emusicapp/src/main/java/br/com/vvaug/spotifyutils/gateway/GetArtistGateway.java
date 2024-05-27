package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.ArtistResponse;

public interface GetArtistGateway {

    ArtistResponse getArtist(String id, String authorization);
}
