package api.endpoints;

import api.base_api.HttpRequestFactory;
import api.data_models.pojo_classes.address.*;
import api.data_models.pojo_classes.balance.PostBalanceRequest;
import api.data_models.pojo_classes.balance.PostBalanceResponse;
import api.data_models.pojo_classes.transaction.GetReceivedTransactionRequest;
import api.data_models.pojo_classes.transaction.GetReceivedTransactionResponse;
import io.restassured.response.Response;

import static api.services.ModulePath.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BlockIoApiEndpoints {
    private final HttpRequestFactory factory;

    public BlockIoApiEndpoints(HttpRequestFactory factory) {
        this.factory = factory;
    }

    public PostNewAddressResponse postNewAddressResponse(PostNewAddressRequest getNewAddressRequest) {
        Response response = factory.requestWithoutAuth()
                .body(getNewAddressRequest)
                .post(BLOCK_IO_NEW_ADDRESS, "")
                .then().log().body().extract().response();

        int expectedStatus = 200;
        assertThat(response.statusCode()).isEqualTo(expectedStatus);

        return response.as(PostNewAddressResponse.class);
    }

    public PostBalanceResponse postBalanceResponse(PostBalanceRequest postBalanceRequest) {
        Response response = factory.requestWithoutAuth()
                .body(postBalanceRequest)
                .post(BLOCK_IO_BALANCE, "")
                .then().log().body().extract().response();

        int expectedStatus = 200;
        assertThat(response.statusCode()).isEqualTo(expectedStatus);

        return response.as(PostBalanceResponse.class);
    }

    public GetReceivedTransactionResponse getReceivedTransactionResponse(GetReceivedTransactionRequest getReceivedTransactionRequest) {
        Response response = factory.requestWithoutAuth()
                .body(getReceivedTransactionRequest)
                .post(BLOCK_IO_TRANSACTION, "/?type=received")
                .then().log().body().extract().response();

        int expectedStatus = 200;
        assertThat(response.statusCode()).isEqualTo(expectedStatus);

        return response.as(GetReceivedTransactionResponse.class);
    }
}
