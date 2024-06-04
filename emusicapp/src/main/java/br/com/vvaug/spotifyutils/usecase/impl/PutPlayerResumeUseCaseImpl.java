package br.com.vvaug.spotifyutils.usecase.impl;

import br.com.vvaug.spotifyutils.gateway.PutPlayerResumeGateway;
import br.com.vvaug.spotifyutils.request.PlayRequest;
import br.com.vvaug.spotifyutils.usecase.PutPlayerResumeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PutPlayerResumeUseCaseImpl implements PutPlayerResumeUseCase {

    private final PutPlayerResumeGateway putPlayerResumeGateway;

    @Override
    public void startResume(String authorization, PlayRequest playRequest) {
        putPlayerResumeGateway.startResume(authorization,playRequest);

    }
}
