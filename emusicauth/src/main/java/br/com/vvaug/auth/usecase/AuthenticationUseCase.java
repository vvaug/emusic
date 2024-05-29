package br.com.vvaug.auth.usecase;

import br.com.vvaug.auth.request.AuthRequest;
import br.com.vvaug.auth.response.AuthResponse;

public interface AuthenticationUseCase {

    AuthResponse execute(AuthRequest authRequest);
}
