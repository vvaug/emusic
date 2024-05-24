package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.SeveralAlbumsResponse;

public interface GetSeveralAlbumsUseCase {

    SeveralAlbumsResponse execute(String ids, String authorization);
}
