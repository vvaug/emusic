package br.com.vvaug.spotifyutils.mock;

import br.com.vvaug.spotifyutils.response.AlbumResponse;
import br.com.vvaug.spotifyutils.response.AlbumTracksResponse;
import br.com.vvaug.spotifyutils.response.SeveralAlbumsResponse;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

import java.io.*;

@UtilityClass
public class ResponseBuilder {

    private static final String BASE_PATH = "src\\main\\resources\\responses\\";
    private static final String ALBUM_RESPONSE = BASE_PATH + "album_response.json";
    private static final String SEVERAL_ALBUMS_RESPONSE = BASE_PATH + "several_albums_response.json";
    private static final String ALBUM_TRACKS_RESPONSE = BASE_PATH + "album_tracks_response.json";
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
}
