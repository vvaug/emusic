package br.com.vvaug.spotifyutils.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlbumItemResponse{

    @JsonAlias("external_urls")
    private ExternalUrlsResponse externalUrls;
    private String href;
    private String id;
    @JsonAlias("is_playable")
    private boolean isPlayable;
    @JsonAlias("linked_from")
    private LinkedFromResponse linkedFrom;
    private RestrictionsResponse restrictions;
    private String name;
    private List<ArtistResponse> artists;
    @JsonAlias("available_markets")
    private List<String> availableMarkets;
    @JsonAlias("disc_number")
    private int discNumber;
    @JsonAlias("duration_ms")
    private int durationMs;
    private boolean explicit;
    @JsonAlias("preview_url")
    private String previewUrl;
    @JsonAlias("track_number")
    private int trackNumber;
    private String type;
    private String uri;
    @JsonAlias("is_local")
    private boolean isLocal;
}
