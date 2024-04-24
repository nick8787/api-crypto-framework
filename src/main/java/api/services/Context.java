package api.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Context {
    @JsonProperty("BLOCK_IO")
    BLOCK_IO("BLOCK_IO");

    private final String name;
}
