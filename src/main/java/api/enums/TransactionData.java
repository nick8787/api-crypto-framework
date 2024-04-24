package api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionData {
    AMOUNT_RECEIVED("0.00012356"),
    RECIPIENT("2N7xFpUptvWp4R8J62HVuQe1GxeufjMjRNf");

    private final String value;
}
