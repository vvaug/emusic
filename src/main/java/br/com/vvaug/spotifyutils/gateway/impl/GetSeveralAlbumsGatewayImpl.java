package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyAlbumClient;
import br.com.vvaug.spotifyutils.gateway.GetSeveralAlbumsGateway;
import br.com.vvaug.spotifyutils.response.SeveralAlbumsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSeveralAlbumsGatewayImpl implements GetSeveralAlbumsGateway {

    private final SpotifyAlbumClient spotifyAlbumClient;
    @Override
    public SeveralAlbumsResponse getSeveralAlbums(String ids, String authorization) {
        return spotifyAlbumClient.getSeveralAlbums(ids, authorization);
    }
}
