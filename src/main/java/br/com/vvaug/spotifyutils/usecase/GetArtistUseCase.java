package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.ArtistResponse;

public interface GetArtistUseCase {

    public ArtistResponse execute (String id, String authorization);
}
