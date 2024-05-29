package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetAlbumTracksGateway;
import br.com.vvaug.spotifyutils.response.AlbumTracksResponse;
import br.com.vvaug.spotifyutils.usecase.GetAlbumTracksUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAlbumTracksUseCaseImpl implements GetAlbumTracksUseCase {

    private final GetAlbumTracksGateway getAlbumTracksGateway;
    @Override
    public AlbumTracksResponse execute(String id, String authorization) {
        return getAlbumTracksGateway.getAlbumTracks(id, authorization);
    }
}
