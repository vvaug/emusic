package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetPlayerStatusGateway;
import br.com.vvaug.spotifyutils.response.PlayerResponse;
import br.com.vvaug.spotifyutils.usecase.GetPlayerStatusUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPlayerStatusUseCaseImpl implements GetPlayerStatusUseCase {

    private final GetPlayerStatusGateway getPlayerStatusGateway;

    @Override
    public PlayerResponse execute(String authorization) {
        return getPlayerStatusGateway.getPLayerState(authorization);
    }
}
