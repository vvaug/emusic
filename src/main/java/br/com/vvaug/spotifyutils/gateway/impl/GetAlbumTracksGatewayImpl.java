package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAlbumClient;
import br.com.vvaug.spotifyutils.gateway.GetAlbumTracksGateway;
import br.com.vvaug.spotifyutils.response.AlbumTracksResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAlbumTracksGatewayImpl implements GetAlbumTracksGateway {

    private final SpotifyAlbumClient spotifyAlbumClient;
    @Override
    public AlbumTracksResponse getAlbumTracks(String id, String authorization) {
        return spotifyAlbumClient.getAlbumTracks(id, authorization);
    }
}
