package br.com.vvaug.auth.usecase;

import br.com.vvaug.auth.response.AuthResponse;
import org.springframework.security.core.Authentication;

public interface GenerateTokenUseCase {

    AuthResponse execute (Authentication authentication);
}
