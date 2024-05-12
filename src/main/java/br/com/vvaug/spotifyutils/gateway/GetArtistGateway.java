package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.ArtistResponse;

public interface GetArtistGateway {

    public ArtistResponse getArtist (String id, String authorization);
}
