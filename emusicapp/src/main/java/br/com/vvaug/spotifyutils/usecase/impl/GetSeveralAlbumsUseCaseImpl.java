package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.impl.GetSeveralAlbumsGatewayImpl;
import br.com.vvaug.spotifyutils.response.SeveralAlbumsResponse;
import br.com.vvaug.spotifyutils.usecase.GetSeveralAlbumsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSeveralAlbumsUseCaseImpl implements GetSeveralAlbumsUseCase {

    private final GetSeveralAlbumsGatewayImpl getSeveralAlbumsGateway;
    @Override
    public SeveralAlbumsResponse execute(String ids, String authorization) {
        return getSeveralAlbumsGateway.getSeveralAlbums(ids, authorization);
    }
}
