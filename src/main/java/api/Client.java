package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class Client{
public static void main(String[] args)throws IOException {
    String accessToken = getAccesstoken();

    OkHttpClient client = new OkHttpClient();

    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(mediaType, "{\"is_private\":false,\"creation_template\":1,\"name\":\"testProject\",\"description\":\"aaaaa\"}");
    Request request = new Request.Builder()
            .url("https://api.taiga.io/api/v1/projects")
            .post(body)
            .addHeader("content-type", "application/json")
            .addHeader("authorization", "Bearer " + accessToken)
            .addHeader("cache-control", "no-cache")
            .addHeader("postman-token", "f1f24751-134b-5e39-8e71-fb8d7d395036")
            .build();

    Response response = client.newCall(request).execute();

    System.out.println(response.body().string());
    }

    public static String getAccesstoken() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"lilysargsyan1992@gmail.com\",\"password\":\"Lsg@taiga8\",\"type\":\"normal\"}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
               .post(body)
               .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache")
               .addHeader("postman-token", "d3f24271-0330-2291-154b-a6d90a92e669")
              .build();

         Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();


        return jsonObject.get("auth_token").getAsString();
    }

}