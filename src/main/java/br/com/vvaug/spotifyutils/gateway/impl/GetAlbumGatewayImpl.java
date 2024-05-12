package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAlbumClient;
import br.com.vvaug.spotifyutils.gateway.GetAlbumGateway;
import br.com.vvaug.spotifyutils.response.AlbumResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAlbumGatewayImpl implements GetAlbumGateway {

    private final SpotifyAlbumClient spotifyAlbumClient;

    @Override
    public AlbumResponse getAlbum(String id, String authorization) {
        return spotifyAlbumClient.getAlbum(id, authorization);
    }
}
