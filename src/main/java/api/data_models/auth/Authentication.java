package api.data_models.auth;

import api.services.Context;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Authentication {
    private Context context;

    public Authentication(Context context) {
        this.context = context;
    }
}
