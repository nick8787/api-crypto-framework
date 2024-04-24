package tests.balance;

import api.data_models.pojo_classes.balance.PostBalanceRequest;
import api.data_models.pojo_classes.balance.PostBalanceResponse;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class GetBalanceTest extends BaseTest {

    @Test
    public void testGetBalance() {
        log.info("Starting test to find wallet balance");

        PostBalanceRequest balanceRequest = blockIoApiRequests.postBalanceRequest();
        PostBalanceResponse balanceResponse = blockIoApiEndpoints.postBalanceResponse(balanceRequest);

        String network = balanceResponse.getData().getNetwork();
        String availableBalance = balanceResponse.getData().getAvailable_balance();
        String receivedBalance = balanceResponse.getData().getPending_received_balance();

        assertThat(balanceResponse)
                .as("Verify the wallet balance details")
                .extracting(
                        response -> response.getData().getNetwork(),
                        response -> response.getData().getAvailable_balance(),
                        response -> response.getData().getPending_received_balance()
                )
                .containsExactly(
                        network,
                        availableBalance,
                        receivedBalance
                );

        log.info("Test completed successfully with available balance: {}", availableBalance);
    }
}
