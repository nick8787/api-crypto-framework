package api.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ModulePath {
    BLOCK_IO_NEW_ADDRESS("/get_new_address"),
    BLOCK_IO_BALANCE("/get_balance"),
    BLOCK_IO_TRANSACTION("/get_transactions");

    private final String name;
}
