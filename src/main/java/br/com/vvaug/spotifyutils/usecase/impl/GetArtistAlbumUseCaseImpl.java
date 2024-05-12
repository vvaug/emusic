package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetArtistAlbumGateway;
import br.com.vvaug.spotifyutils.response.AlbumResponse;
import br.com.vvaug.spotifyutils.usecase.GetArtistAlbumUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArtistAlbumUseCaseImpl implements GetArtistAlbumUseCase {

    private final GetArtistAlbumGateway getArtistAlbumGateway;
    @Override
    public AlbumResponse execute(String id, String authorization) {
        return getArtistAlbumGateway.getArtistAlbum(id, authorization);
    }
}
