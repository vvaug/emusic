package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetAlbumGateway;
import br.com.vvaug.spotifyutils.response.AlbumResponse;
import br.com.vvaug.spotifyutils.usecase.GetAlbumUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAlbumUseCaseImpl implements GetAlbumUseCase {

    private final GetAlbumGateway getAlbumGateway;
    @Override
    public AlbumResponse execute(String id, String authorization) {
        return getAlbumGateway.getAlbum(id, authorization);
    }
}
