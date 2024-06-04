package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.GetPlayerAvaibleDevicesGateway;
import br.com.vvaug.spotifyutils.response.PlayerDeviceList;
import br.com.vvaug.spotifyutils.usecase.GetPlayerAvaibleDevicesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPlayerAvaibleDevicesUseCaseImpl implements GetPlayerAvaibleDevicesUseCase {

    private final GetPlayerAvaibleDevicesGateway getPlayerAvaibleDevicesGateway;
    @Override
    public PlayerDeviceList execute(String authorization) {
        return getPlayerAvaibleDevicesGateway.getAvaibleDevices(authorization);
    }
}
