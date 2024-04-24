package tests;

import api.base_api.HttpRequestFactory;
import api.data_models.auth.Authentication;
import api.endpoints.BlockIoApiEndpoints;
import api.endpoints.BlockIoApiRequests;
import api.services.Context;

public class BaseTest {

    static Authentication authentication = new Authentication(Context.BLOCK_IO);
    static HttpRequestFactory httpRequestFactory = new HttpRequestFactory(authentication);
    protected static BlockIoApiEndpoints blockIoApiEndpoints = new BlockIoApiEndpoints(httpRequestFactory);
    protected static BlockIoApiRequests blockIoApiRequests = new BlockIoApiRequests(blockIoApiEndpoints);

}
