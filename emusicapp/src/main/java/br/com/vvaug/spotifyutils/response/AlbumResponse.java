package br.com.vvaug.spotifyutils.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlbumResponse {

    @JsonAlias("album_type")
    private String albumType;
    @JsonAlias("total_tracks")
    private int totalTracks;
    @JsonAlias("available_markets")
    private List<String> availableMarkets;
    @JsonAlias("external_urls")
    private ExternalUrlsResponse externalUrls;
    private String href;
    private String id;
    private List<ImageResponse> images;
    private String name;
    @JsonAlias("release_date")
    private String releaseDate;
    @JsonAlias("release_date_precision")
    private String releaseDatePrecision;
    private RestrictionsResponse restrictions;
    private String type;
    private String uri;
    private List<ArtistResponse> artists;
    private AlbumTracksResponse tracks;
    private ArrayList<CopyrightResponse> copyrights;
    @JsonAlias("external_ids")
    private ExternalIdsResponse externalIds;
    private ArrayList<String> genres;
    private String label;
    private int popularity;
}
