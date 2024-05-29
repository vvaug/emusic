package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.gateway.GetArtistGateway;
import br.com.vvaug.spotifyutils.response.ArtistResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArtistGatewayImpl implements GetArtistGateway {

    private final SpotifyArtistClient getArtistClient;
    @Override
    public ArtistResponse getArtist(String id, String authorization) {
        return getArtistClient.getArtist(id, authorization);
    }
}
