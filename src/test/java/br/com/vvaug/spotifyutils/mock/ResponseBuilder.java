package br.com.vvaug.spotifyutils.mock;

import br.com.vvaug.spotifyutils.response.*;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
@Slf4j
public class ResponseBuilder {
    private static final String ERROR_FILE_NOT_FOUND = "File not found: {}";
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
    private static final Gson gson = new Gson();
    private File file;

    public static AlbumResponse buildAlbumResponse(){
        file = new File(ALBUM_RESPONSE);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), AlbumResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, ALBUM_RESPONSE);
            return AlbumResponse.builder().build();
        }
    }

    public static SeveralAlbumsResponse buildSeveralAlbumsResponse(){
        file = new File(SEVERAL_ALBUMS_RESPONSE);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), SeveralAlbumsResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, SEVERAL_ALBUMS_RESPONSE);
            return SeveralAlbumsResponse.builder().build();
        }
    }

    public static AlbumTracksResponse buildAlbumTracksResponse(){
        file = new File(ALBUM_TRACKS_RESPONSE);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), AlbumTracksResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, ALBUM_TRACKS_RESPONSE);
            return AlbumTracksResponse.builder().build();
        }
    }

    public static ArtistResponse buildArtistResponse(){
        file = new File(ARTIST_RESPONSE);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), ArtistResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, ARTIST_RESPONSE);
            return ArtistResponse.builder().build();
        }
    }

    public static SeveralArtistsResponse buildArtistsResponse(){
        file = new File(ARTISTS_RESPONSE);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), SeveralArtistsResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, ARTISTS_RESPONSE);
            return SeveralArtistsResponse.builder().build();
        }
    }

    public static ArtistAlbumResponse buildArtistsAlbumResponse(){
        file = new File(ARTISTS_ALBUM_RESPONSE);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), ArtistAlbumResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, ARTISTS_ALBUM_RESPONSE);
            return ArtistAlbumResponse.builder().build();
        }
    }

    public static ArtistTopTracksResponse buildArtistsTopTracksResponse(){
        file = new File(ARTISTS_TOP_TRACKS);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), ArtistTopTracksResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, ARTISTS_TOP_TRACKS);
            return ArtistTopTracksResponse.builder().build();
        }
    }

    public static RelatedArtistsResponse buildArtistsRelated(){
        file = new File(ARTISTS_RELATED);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), RelatedArtistsResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, ARTISTS_RELATED);
            return RelatedArtistsResponse.builder().build();
        }
    }

    public static SeveralCategoriesResponse buildSeveralCategories(){
        file = new File(SEVERAL_CATEGORIES);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), SeveralCategoriesResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, SEVERAL_CATEGORIES);
            return SeveralCategoriesResponse.builder().build();
        }
    }

    public static CategoriesItemResponse buildSingleCategory(){
        file = new File(SINGLE_CATEGORY);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), CategoriesItemResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, SINGLE_CATEGORY);
            return CategoriesItemResponse.builder().build();
        }
    }

    public static EpisodeResponse buildEpisodeResponse(){
        file = new File(EPISODE_RESPONSE);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), EpisodeResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, EPISODE_RESPONSE);
            return EpisodeResponse.builder().build();
        }
    }

    public static SeveralEpisodesResponse buildEpisodeSeveralResponse(){
        file = new File(EPISODE_SEVERAL_RESPONSE);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), SeveralEpisodesResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, EPISODE_SEVERAL_RESPONSE);
            return SeveralEpisodesResponse.builder().build();
        }
    }

    public static GenresResponse buildGenresResponse(){
        file = new File(GENRES_RESPONSE);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), GenresResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, GENRES_RESPONSE);
            return GenresResponse.builder().build();
        }
    }

    public static MarketsResponse buildMarketsResponse() {
        file = new File(MARKETS_RESPONSE);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), MarketsResponse.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, MARKETS_RESPONSE);
            return MarketsResponse.builder().build();
        }
    }

}
