package api.data_models.pojo_classes.transaction;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetReceivedTransactionRequest {

    private String api_key;

}
