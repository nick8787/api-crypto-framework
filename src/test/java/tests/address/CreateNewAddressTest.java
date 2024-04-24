package tests.address;

import api.data_models.pojo_classes.address.PostNewAddressRequest;
import api.data_models.pojo_classes.address.PostNewAddressResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import tests.BaseTest;

@Slf4j
public class CreateNewAddressTest extends BaseTest {

    @Test(description = "Create new wallet")
    public void testGetNewAddress() {
        log.info("Starting test for creating new Wallet");

        PostNewAddressRequest addressRequest = blockIoApiRequests.postNewAddressRequest();
        PostNewAddressResponse addressResponse = blockIoApiEndpoints.postNewAddressResponse(addressRequest);
    }
}
