package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.SeveralArtistsResponse;

public interface GetSeveralArtistsUseCase {

    SeveralArtistsResponse execute(String ids, String authorization);
}
