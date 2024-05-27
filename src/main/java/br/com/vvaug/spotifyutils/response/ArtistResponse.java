package br.com.vvaug.spotifyutils.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArtistResponse {

    @JsonAlias("external_urls")
    private ExternalUrlsResponse externalUrls;
    private FollowersResponse followers;
    private List<String> genres;
    private String href;
    private String id;
    private List<ImageResponse> images;
    private String name;
    private int popularity;
    private String type;
    private String uri;
}
