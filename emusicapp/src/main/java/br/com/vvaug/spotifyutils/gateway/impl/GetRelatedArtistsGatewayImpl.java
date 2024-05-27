package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.gateway.GetRelatedArtistsGateway;
import br.com.vvaug.spotifyutils.response.RelatedArtistsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetRelatedArtistsGatewayImpl implements GetRelatedArtistsGateway {

    private final SpotifyArtistClient spotifyArtistClient;
    @Override
    public RelatedArtistsResponse getRelatedArtists(String id, String authorization) {
        return spotifyArtistClient.getRelatedArtists(id, authorization);
    }
}
