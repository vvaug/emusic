package br.com.vvaug.spotifyutils.response;

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

    private String album_type;
    private int total_tracks;
    private List<String> available_markets;
    private ExternalUrlsResponse external_urls;
    private String href;
    private String id;
    private List<ImageResponse> images;
    private String name;
    private String release_date;
    private String release_date_precision;
    private RestrictionsResponse restrictions;
    private String type;
    private String uri;
    private List<ArtistResponse> artists;
    private AlbumTracksResponse tracks;
    private ArrayList<CopyrightResponse> copyrights;
    private ExternalIdsResponse external_ids;
    private ArrayList<String> genres;
    private String label;
    private int popularity;
}
