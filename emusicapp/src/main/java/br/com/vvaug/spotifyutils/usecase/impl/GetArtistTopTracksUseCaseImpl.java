package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetArtistTopTracksGateway;
import br.com.vvaug.spotifyutils.response.ArtistTopTracksResponse;
import br.com.vvaug.spotifyutils.usecase.GetArtistTopTracksUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArtistTopTracksUseCaseImpl implements GetArtistTopTracksUseCase {

    private final GetArtistTopTracksGateway getArtistTopTracksGateway;
    @Override
    public ArtistTopTracksResponse execute(String id, String authorization) {
        return getArtistTopTracksGateway.getArtistTopTracks(id, authorization);
    }
}
