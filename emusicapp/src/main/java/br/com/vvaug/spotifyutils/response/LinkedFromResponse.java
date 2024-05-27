package br.com.vvaug.spotifyutils.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkedFromResponse {

    @JsonAlias("external_urls")
    private ExternalUrlsResponse externalUrls;
    private String href;
    private String id;
    private String type;
    private String uri;

}
