package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.PlayerDeviceList;

public interface GetPlayerAvaibleDevicesGateway {

    PlayerDeviceList getAvaibleDevices(String authorization);

}
