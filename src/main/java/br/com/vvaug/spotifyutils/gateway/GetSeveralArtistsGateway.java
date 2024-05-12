package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.SeveralArtistsResponse;

public interface GetSeveralArtistsGateway {

    SeveralArtistsResponse getArtists(String ids, String authorization);
}
