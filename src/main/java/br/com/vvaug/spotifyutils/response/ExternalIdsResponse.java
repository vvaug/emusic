package br.com.vvaug.spotifyutils.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExternalIdsResponse {

    private String isrc;
    private String ean;
    private String upc;
}
