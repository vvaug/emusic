package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetArtistGateway;
import br.com.vvaug.spotifyutils.response.ArtistResponse;
import br.com.vvaug.spotifyutils.usecase.GetArtistUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArtistUseCaseImpl implements GetArtistUseCase {

    private final GetArtistGateway getArtistGateway;
    @Override
    public ArtistResponse execute(String id, String authorization) {
        return getArtistGateway.getArtist(id, authorization);
    }
}
