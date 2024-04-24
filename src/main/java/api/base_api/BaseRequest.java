package api.base_api;

import api.envs.EnvSettings;
import api.for_json.JsonPayloadHandler;
import api.services.Context;
import api.services.ModulePath;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class BaseRequest {

    private final RequestSpecification requestSpecification;
    @Getter
    @Setter
    private Context context;

    public BaseRequest() {
        requestSpecification = given()
                .spec(new RequestSpecBuilder()
                        .setUrlEncodingEnabled(false)
                        .build())
                .log().method()
                .log().body()
                .log().uri()
                .log().headers();
    }

    public Response get(ModulePath modulePath, String route) {
        return requestSpecification.get(getUrl(modulePath, route));
    }

    public Response post(ModulePath modulePath, String route) {
        return requestSpecification.post(getUrl(modulePath, route));
    }

    public BaseRequest body(Object body) {
        JsonPayloadHandler payloadHandler = new JsonPayloadHandler();

        if (body != null) {
            requestSpecification.contentType(ContentType.JSON)
                    .body(payloadHandler.toPayload(body));
        }
        return this;
    }

    private String getUrl(ModulePath modulePath, String path) {
        EnvSettings.setBaseUrls();
        String baseUrl = "";

        if (Objects.requireNonNull(this.context) == Context.BLOCK_IO) {
            baseUrl = System.getProperty("baseBLOCKIOUrl");
        }

        return baseUrl
                .concat(modulePath.getName())
                .concat(path);
    }
}
