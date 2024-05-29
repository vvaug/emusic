package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.RelatedArtistsResponse;

public interface GetRelatedArtistsGateway {

    RelatedArtistsResponse getRelatedArtists(String id, String authorization);
}
