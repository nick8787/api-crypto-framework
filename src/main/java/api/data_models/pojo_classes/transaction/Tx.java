package api.data_models.pojo_classes.transaction;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
public class Tx {

    private String txid;
    private Boolean from_green_address;
    private Integer time;
    private Integer confirmations;
    private ArrayList<AmountsReceived> amounts_received;
    private ArrayList<String> senders;
    private Double confidence;
    private Object propagated_by_nodes;

}
