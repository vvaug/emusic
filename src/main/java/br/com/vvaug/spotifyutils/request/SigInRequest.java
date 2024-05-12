package br.com.vvaug.spotifyutils.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SigInRequest {

    private String clientId;
    private String clientSecret;
    private String grantType;
}
