package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.gateway.GetArtistTopTracksGateway;
import br.com.vvaug.spotifyutils.response.ArtistTopTracksResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArtistTopTracksGatewayImpl implements GetArtistTopTracksGateway {

    private final SpotifyArtistClient spotifyArtistClient;
    @Override
    public ArtistTopTracksResponse getArtistTopTracks(String id, String authorization) {
        return spotifyArtistClient.getArtistTopTracks(id, authorization);
    }
}
