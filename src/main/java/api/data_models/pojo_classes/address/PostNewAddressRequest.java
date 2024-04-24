package api.data_models.pojo_classes.address;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostNewAddressRequest {

    private String api_key;

}
