package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyPlayerClient;
import br.com.vvaug.spotifyutils.gateway.PutPlayerStatusGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PutPlayerStatusGatewayImpl implements PutPlayerStatusGateway {

    private final SpotifyPlayerClient spotifyPlayerClient;

    public void updatePlayerDevice(String authorization, List<String> devicesId) {
        spotifyPlayerClient.updatePlayerDevice(authorization,devicesId);
    }

}
