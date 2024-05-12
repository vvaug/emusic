package br.com.vvaug.spotifyutils.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TrackResponse {

    private AlbumResponse album;
    private ArrayList<ArtistResponse> artists;
    private ArrayList<String> available_markets;
    private int disc_number;
    private int duration_ms;
    private boolean explicit;
    private ExternalIdsResponse external_ids;
    private ExternalUrlsResponse external_urls;
    private String href;
    private String id;
    private boolean is_playable;
    private LinkedFromResponse linked_from;
    private RestrictionsResponse restrictions;
    private String name;
    private int popularity;
    private String preview_url;
    private int track_number;
    private String type;
    private String uri;
    private boolean is_local;
}
