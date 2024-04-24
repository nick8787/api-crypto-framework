package api.data_models.pojo_classes.balance;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostBalanceRequest {

    private String api_key;

}
