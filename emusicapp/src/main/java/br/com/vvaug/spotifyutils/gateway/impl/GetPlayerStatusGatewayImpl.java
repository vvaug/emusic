package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyPlayerClient;
import br.com.vvaug.spotifyutils.gateway.GetPlayerStatusGateway;
import br.com.vvaug.spotifyutils.response.PlayerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPlayerStatusGatewayImpl implements GetPlayerStatusGateway {

    private final SpotifyPlayerClient spotifyPlayerClient;

    @Override
    public PlayerResponse getPLayerState(String authorization) {
        return spotifyPlayerClient.getPLayerState(authorization);
    }
}
