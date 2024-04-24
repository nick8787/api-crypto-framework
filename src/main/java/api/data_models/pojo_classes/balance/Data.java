package api.data_models.pojo_classes.balance;

import lombok.*;

@Getter
@Setter
public class Data {

    private String network;
    private String available_balance;
    private String pending_received_balance;

}
