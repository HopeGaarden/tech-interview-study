package hw8.deserializer;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Type;
import java.util.Optional;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import hw8.periodic.ChemicalCompound;
import hw8.periodic.Element;
import hw8.periodic.Phase;
import hw8.state.*;

public class ChemicalCompoundDeserializer implements JsonDeserializer<ChemicalCompound> {
    @Override
    public ChemicalCompound deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        // JSON 데이터 파싱
        String name = jsonObject.get("name").getAsString();
        String symbol = jsonObject.get("symbol").getAsString();
        Optional<Double> meltingPoint = Optional.ofNullable(jsonObject.get("meltingPoint")).map(JsonElement::getAsDouble);
        Optional<Double> boilingPoint = Optional.ofNullable(jsonObject.get("boilingPoint")).map(JsonElement::getAsDouble);

        // 구성 원소 설정
        Map<Element, Integer> compounds = new HashMap<>();
        JsonArray compoundsArray = jsonObject.getAsJsonArray("compounds");
        for (JsonElement compoundElement : compoundsArray) {
            JsonObject compoundObject = compoundElement.getAsJsonObject();
            JsonObject elementObject = compoundObject.getAsJsonObject("Element");
            Element element = context.deserialize(elementObject, Element.class);
            int count = compoundObject.get("count").getAsInt();
            compounds.put(element, count);
        }

        // 화합물 생성
        ChemicalCompound compound = new ChemicalCompound(name, symbol, compounds);

        // 녹는점, 끓는점 설정
        compound.setMeltingPoint(meltingPoint);
        compound.setBoilingPoint(boilingPoint);

        // state 이름을 얻어와 이름에 따라 상태 설정
        String stateName = jsonObject.get("state").getAsString();
        State<ChemicalCompound> state;
        switch (stateName.toLowerCase()) {
            case "gas":
                state = new GasState<ChemicalCompound>();
                break;
            case "liq":
                state = new LiquidState<ChemicalCompound>();
                break;
            case "solid":
                state = new SolidState<ChemicalCompound>();
                break;
            case "artificial":
                state = new ArtificialState<ChemicalCompound>();
                break;
            default:
                throw new IllegalArgumentException("Unknown state name: " + stateName);
        }
        compound.setState(state);

        // 완성된 ChemicalCompound 반환
        return compound;
    }

}
