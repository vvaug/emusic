package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetRelatedArtistsGateway;
import br.com.vvaug.spotifyutils.response.RelatedArtistsResponse;
import br.com.vvaug.spotifyutils.usecase.GetRelatedArtistsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetRelatedArtistsUseCaseImpl implements GetRelatedArtistsUseCase {

    private final GetRelatedArtistsGateway getRelatedArtistsGateway;
    @Override
    public RelatedArtistsResponse execute(String id, String authorization) {
        return getRelatedArtistsGateway.getRelatedArtists(id, authorization);
    }
}
