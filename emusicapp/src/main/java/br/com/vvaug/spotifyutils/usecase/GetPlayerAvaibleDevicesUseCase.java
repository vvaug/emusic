package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.PlayerDeviceList;

public interface GetPlayerAvaibleDevicesUseCase {

    PlayerDeviceList execute(String authorization);
}
