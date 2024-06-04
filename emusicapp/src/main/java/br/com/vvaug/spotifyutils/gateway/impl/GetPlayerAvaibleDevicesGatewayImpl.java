package br.com.vvaug.spotifyutils.gateway.impl;

import br.com.vvaug.spotifyutils.client.SpotifyPlayerClient;
import br.com.vvaug.spotifyutils.gateway.GetPlayerAvaibleDevicesGateway;
import br.com.vvaug.spotifyutils.response.PlayerDeviceList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPlayerAvaibleDevicesGatewayImpl implements GetPlayerAvaibleDevicesGateway {

    private final SpotifyPlayerClient spotifyPlayerClient;

    @Override
    public PlayerDeviceList getAvaibleDevices(String authorization) {
        return spotifyPlayerClient.getAvaibleDevices(authorization);
    }
}
