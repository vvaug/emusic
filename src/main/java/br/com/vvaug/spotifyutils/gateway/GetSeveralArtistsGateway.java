package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.ArtistResponse;
import br.com.vvaug.spotifyutils.response.SeveralArtistsResponse;

import java.util.List;

public interface GetSeveralArtistsGateway {

    SeveralArtistsResponse getArtists(String ids, String authorization);
}
