package br.com.vvaug.spotifyutils.gateway;

import java.util.List;

public interface PutPlayerStatusGateway {

    void updatePlayerDevice(String authorization, List<String> devicesId);

}
