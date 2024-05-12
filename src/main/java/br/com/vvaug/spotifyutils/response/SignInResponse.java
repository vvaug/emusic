package br.com.vvaug.spotifyutils.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignInResponse {

    private String access_token;
    private String token_type;
    private String expires_in;
}
