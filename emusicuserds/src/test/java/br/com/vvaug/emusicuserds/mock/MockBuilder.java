package br.com.vvaug.emusicuserds.mock;

import br.com.vvaug.emusicuserds.entity.User;
import br.com.vvaug.emusicuserds.request.CreateUserRequest;
import com.google.gson.*;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;

@UtilityClass
@Slf4j
public class MockBuilder {

    private static final String ERROR_FILE_NOT_FOUND = "File not found: {}";
    private static final String RESPONSES_BASE_PATH = "src\\main\\resources\\responses\\";
    private static final String REQUESTS_BASE_PATH = "src\\main\\resources\\requests\\";

    private static final String USER = RESPONSES_BASE_PATH + "user.json";
    private static final String CREATE_USER_REQUEST = REQUESTS_BASE_PATH + "create_user_request.json";

    private static final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
        @Override
        public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
        }
    }).create();

    private File file;

    public static User buildUser(){
        file = new File(USER);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), User.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, USER);
            return User.builder().build();
        }
    }

    public static CreateUserRequest buildCreateUserRequest(){
        file = new File(CREATE_USER_REQUEST);
        try {
            return gson.fromJson(new BufferedReader(new FileReader(file.getPath())), CreateUserRequest.class);
        } catch (FileNotFoundException ex) {
            log.info(ERROR_FILE_NOT_FOUND, CREATE_USER_REQUEST);
            return CreateUserRequest.builder().build();
        }
    }



}
