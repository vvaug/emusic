package br.com.vvaug.spotifyutils.mock;

import br.com.vvaug.spotifyutils.response.*;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

import java.io.*;

@UtilityClass
public class ResponseBuilder {

    private static final String BASE_PATH = "src\\main\\resources\\responses\\";
    private static final String ALBUM_RESPONSE = BASE_PATH + "album_response.json";
    private static final String SEVERAL_ALBUMS_RESPONSE = BASE_PATH + "several_albums_response.json";
    private static final String ALBUM_TRACKS_RESPONSE = BASE_PATH + "album_tracks_response.json";
    private static final String ARTIST_RESPONSE = BASE_PATH + "artist_response.json";
    private static final String ARTISTS_RESPONSE = BASE_PATH + "artists_response.json";
    private static final String ARTISTS_ALBUM_RESPONSE = BASE_PATH + "artists_album_response.json";
    private static final String ARTISTS_TOP_TRACKS = BASE_PATH + "artists_top_tracks_response.json";
    private static final String ARTISTS_RELATED = BASE_PATH + "artists_related_response.json";
    private static final String SEVERAL_CATEGORIES = BASE_PATH + "categories_several_response.json";
    private static final String SINGLE_CATEGORY = BASE_PATH + "category_single_response.json";
    private static final String EPISODE_RESPONSE = BASE_PATH + "episode_response.json";
    private static final String EPISODE_SEVERAL_RESPONSE = BASE_PATH + "episode_several_response.json";
    private static final String GENRES_RESPONSE = BASE_PATH + "genres_response.json";
    private static final String MARKETS_RESPONSE = BASE_PATH + "markets_response.json";
    private Gson gson;
    private File file;

    public static AlbumResponse buildAlbumResponse() throws IOException {
        file = new File(ALBUM_RESPONSE);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), AlbumResponse.class);
    }

    public static SeveralAlbumsResponse buildSeveralAlbumsResponse() throws FileNotFoundException {
        file = new File(SEVERAL_ALBUMS_RESPONSE);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), SeveralAlbumsResponse.class);
    }

    public static AlbumTracksResponse buildAlbumTracksResponse() throws FileNotFoundException {
        file = new File(ALBUM_TRACKS_RESPONSE);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), AlbumTracksResponse.class);
    }

    public static ArtistResponse buildArtistResponse() throws IOException {
        file = new File(ARTIST_RESPONSE);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), ArtistResponse.class);
    }

    public static SeveralArtistsResponse buildArtistsResponse() throws IOException {
        file = new File(ARTISTS_RESPONSE);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), SeveralArtistsResponse.class);
    }

    public static ArtistAlbumResponse buildArtistsAlbumResponse()throws IOException {
        file = new File(ARTISTS_ALBUM_RESPONSE);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), ArtistAlbumResponse.class);
    }

    public static ArtistTopTracksResponse buildArtistsTopTracksResponse()throws IOException {
        file = new File(ARTISTS_TOP_TRACKS);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), ArtistTopTracksResponse.class);
    }

    public static RelatedArtistsResponse buildArtistsRelated()throws IOException {
        file = new File(ARTISTS_RELATED);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), RelatedArtistsResponse.class);
    }

    public static SeveralCategoriesResponse buildSeveralCategories()throws IOException {
        file = new File(SEVERAL_CATEGORIES);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), SeveralCategoriesResponse.class);
    }

    public static CategoriesItemResponse buildSingleCategory()throws IOException {
        file = new File(SINGLE_CATEGORY);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), CategoriesItemResponse.class);
    }

    public static EpisodeResponse buildEpisodeResponse()throws IOException {
        file = new File(EPISODE_RESPONSE);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), EpisodeResponse.class);
    }

    public static SeveralEpisodesResponse buildEpisodeSeveralResponse()throws IOException {
        file = new File(EPISODE_SEVERAL_RESPONSE);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), SeveralEpisodesResponse.class);
    }

    public static GenresResponse buildGenresResponse()throws IOException {
        file = new File(GENRES_RESPONSE);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), GenresResponse.class);
    }

    public static MarketsResponse buildMarketsResponse()throws IOException {
        file = new File(MARKETS_RESPONSE);
        gson = new Gson();
        return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), MarketsResponse.class);
    }

}
