package br.com.vvaug.spotifyutils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkedFromResponse {

    private ExternalUrlsResponse external_urls;
    private String href;
    private String id;
    private String type;
    private String uri;

}
