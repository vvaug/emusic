package br.com.vvaug.spotifyutils.gateway;

import br.com.vvaug.spotifyutils.request.PlayRequest;

public interface PutPlayerResumeGateway {

    void startResume(String authorization, PlayRequest playRequest);

}
