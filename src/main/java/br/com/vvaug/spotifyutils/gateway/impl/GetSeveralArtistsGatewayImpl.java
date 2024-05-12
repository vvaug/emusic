package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.gateway.GetSeveralArtistsGateway;
import br.com.vvaug.spotifyutils.response.ArtistResponse;
import br.com.vvaug.spotifyutils.response.SeveralArtistsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetSeveralArtistsGatewayImpl implements GetSeveralArtistsGateway {

    private final SpotifyArtistClient spotifyArtistClient;
    @Override
    public SeveralArtistsResponse getArtists(String ids, String authorization) {
        return spotifyArtistClient.getArtists(ids, authorization);
    }
}
