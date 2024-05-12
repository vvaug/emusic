package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.GetArtistClient;
import br.com.vvaug.spotifyutils.gateway.GetArtistGateway;
import br.com.vvaug.spotifyutils.response.ArtistResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArtistGatewayImpl implements GetArtistGateway {

    private final GetArtistClient getArtistClient;
    @Override
    public ArtistResponse getArtist(String id, String authorization) {
        return getArtistClient.getArtist(id, authorization);
    }
}
