package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.ArtistResponse;
import br.com.vvaug.spotifyutils.response.SeveralArtistsResponse;

import java.util.List;

public interface GetSeveralArtistsUseCase {

    public SeveralArtistsResponse execute(String ids, String authorization);
}
