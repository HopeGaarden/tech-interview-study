package hw8.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.util.Optional;

public class DoubleOptionalDeserializer implements JsonDeserializer<Optional<Double>> {
    @Override
    public Optional<Double> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isNumber()) {
            return Optional.of(json.getAsDouble());
        } else {
            return Optional.empty();
        }
    }
}
