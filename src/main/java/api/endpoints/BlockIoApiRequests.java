package api.endpoints;

import api.data_models.pojo_classes.address.PostNewAddressRequest;
import api.data_models.pojo_classes.balance.PostBalanceRequest;
import api.data_models.pojo_classes.transaction.GetReceivedTransactionRequest;

public class BlockIoApiRequests {
    final BlockIoApiEndpoints blockIoApiEndpoints;

    public BlockIoApiRequests(BlockIoApiEndpoints blockIoApiEndpoints) {
        this.blockIoApiEndpoints = blockIoApiEndpoints;
    }

    public PostNewAddressRequest postNewAddressRequest() {
        return PostNewAddressRequest.builder()
                .api_key("7346-b285-532b-ba3f")
                .build();
    }

    public PostBalanceRequest postBalanceRequest() {
        return PostBalanceRequest.builder()
                .api_key("7346-b285-532b-ba3f")
                .build();
    }

    public GetReceivedTransactionRequest getReceivedTransactionRequest() {
        return GetReceivedTransactionRequest.builder()
                .api_key("7346-b285-532b-ba3f")
                .build();
    }
}
