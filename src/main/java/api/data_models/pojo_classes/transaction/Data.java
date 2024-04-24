package api.data_models.pojo_classes.transaction;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
public class Data {

    private String network;
    private ArrayList<Tx> txs;

}
