package api.base_api;

import api.data_models.auth.Authentication;

public class HttpRequestFactory {
    final Authentication authentication;

    public HttpRequestFactory(Authentication authentication) {
        this.authentication = authentication;
    }

    public BaseRequest requestWithoutAuth() {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.setContext(authentication.getContext());
        return baseRequest;
    }
}
