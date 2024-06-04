package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.PlayerResponse;

public interface GetPlayerStatusGateway {

    PlayerResponse getPLayerState(String authorization);

}
