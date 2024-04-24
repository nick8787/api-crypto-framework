package tests.transaction;

import api.data_models.pojo_classes.transaction.*;
import api.enums.TransactionData;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class GetReceivedTransactionTest extends BaseTest {

    private final String amountReceived = TransactionData.AMOUNT_RECEIVED.getValue();
    private final String recipient = TransactionData.RECIPIENT.getValue();

    @Test
    public void testGetTransaction() {
        log.info("Starting a test to get information about received transactions");

        GetReceivedTransactionRequest transactionRequest = blockIoApiRequests.getReceivedTransactionRequest();
        GetReceivedTransactionResponse transactionResponse = blockIoApiEndpoints.getReceivedTransactionResponse(transactionRequest);

        Data transactionData = transactionResponse.getData();
        Tx firstTransaction = transactionData.getTxs().getFirst();
        AmountsReceived firstAmountReceived = firstTransaction.getAmounts_received().getFirst();
        String sender = firstTransaction.getSenders().getFirst();

        assertThat(firstAmountReceived)
                .as("Check received amount and recipient")
                .extracting(
                        AmountsReceived::getAmount,
                        AmountsReceived::getRecipient
                )
                .containsExactly(
                        amountReceived,
                        recipient
                );

        log.info("Test completed successfully with amount received: {}, sender: {}", amountReceived, sender);
    }
}
