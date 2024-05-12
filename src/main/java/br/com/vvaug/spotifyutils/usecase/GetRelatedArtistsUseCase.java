package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.response.RelatedArtistsResponse;

public interface GetRelatedArtistsUseCase {

    RelatedArtistsResponse execute(String id, String authorization);
}
