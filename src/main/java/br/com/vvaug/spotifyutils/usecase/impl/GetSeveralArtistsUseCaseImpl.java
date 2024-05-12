package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetSeveralArtistsGateway;
import br.com.vvaug.spotifyutils.response.SeveralArtistsResponse;
import br.com.vvaug.spotifyutils.usecase.GetSeveralArtistsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSeveralArtistsUseCaseImpl implements GetSeveralArtistsUseCase {

    private final GetSeveralArtistsGateway getSeveralArtistsGateway;
    @Override
    public SeveralArtistsResponse execute(String ids, String authorization) {
        return getSeveralArtistsGateway.getArtists(ids, authorization);
    }
}
