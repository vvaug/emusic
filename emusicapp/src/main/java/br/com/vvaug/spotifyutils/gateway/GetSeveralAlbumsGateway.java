package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.response.SeveralAlbumsResponse;

public interface GetSeveralAlbumsGateway {

    SeveralAlbumsResponse getSeveralAlbums(String ids, String authorization);
}
