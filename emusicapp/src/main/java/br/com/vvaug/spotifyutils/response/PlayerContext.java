package br.com.vvaug.spotifyutils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class PlayerContext {

    private String type;
    private String href;
    private ExternalUrlsResponse external_urls;
    private String uri;

}
