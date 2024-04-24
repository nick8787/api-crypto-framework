package api.for_json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;

public class JsonPayloadHandler implements PayloadHandler {
    private final ObjectMapper mapper;

    public JsonPayloadHandler() {
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    }

    @Override
    @SneakyThrows
    public String toPayload(Object entity) {
        return mapper.writeValueAsString(entity);
    }
}
