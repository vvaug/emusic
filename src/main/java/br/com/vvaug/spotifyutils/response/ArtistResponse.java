package br.com.vvaug.spotifyutils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArtistResponse {

    private ExternalUrlsResponse external_urls;
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
