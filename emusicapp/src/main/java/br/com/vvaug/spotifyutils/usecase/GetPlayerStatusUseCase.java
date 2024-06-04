package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.PlayerResponse;

public interface GetPlayerStatusUseCase {

    PlayerResponse execute(String authorization);
}
