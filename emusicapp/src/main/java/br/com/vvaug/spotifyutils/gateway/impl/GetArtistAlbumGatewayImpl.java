package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyArtistClient;
import br.com.vvaug.spotifyutils.gateway.GetArtistAlbumGateway;
import br.com.vvaug.spotifyutils.response.ArtistAlbumResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArtistAlbumGatewayImpl implements GetArtistAlbumGateway {

    private final SpotifyArtistClient spotifyArtistClient;
    @Override
    public ArtistAlbumResponse getArtistAlbum(String id, String authorization) {
        return spotifyArtistClient.getAlbums(id, authorization);
    }
}
