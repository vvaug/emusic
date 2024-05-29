package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.ArtistTopTracksResponse;

public interface GetArtistTopTracksGateway {

    ArtistTopTracksResponse getArtistTopTracks(String id, String authorization);
}
