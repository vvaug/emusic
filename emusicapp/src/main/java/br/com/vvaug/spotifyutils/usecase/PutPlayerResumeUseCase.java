package br.com.vvaug.spotifyutils.usecase;

import br.com.vvaug.spotifyutils.request.PlayRequest;

public interface PutPlayerResumeUseCase {

    void startResume(String authorization, PlayRequest playRequest);
}
