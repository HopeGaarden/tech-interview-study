package hw8.deserializer;

import java.lang.reflect.Type;
import java.util.Optional;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import hw8.periodic.Element;
import hw8.state.*;

public class ElementDeserializer implements JsonDeserializer<Element> {
    @Override
    public Element deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        JsonObject jsonObject = json.getAsJsonObject();

        // JSON 데이터 파싱
        int number = jsonObject.get("number").getAsInt();
        String name = jsonObject.get("name").getAsString();
        String symbol = jsonObject.get("symbol").getAsString();
        double weight = jsonObject.get("weight").getAsDouble();
        int period = jsonObject.get("period").getAsInt();
        int group = jsonObject.get("group").getAsInt();
        String type = jsonObject.get("type").getAsString();
        Optional<Double> meltingPoint = Optional.ofNullable(jsonObject.get("meltingPoint")).map(JsonElement::getAsDouble);
        Optional<Double> boilingPoint = Optional.ofNullable(jsonObject.get("boilingPoint")).map(JsonElement::getAsDouble);

        // Element 생성 해준 후 녹는점, 끓는점 설정
        Element e = new Element(number, name, symbol, weight, period, group, type);

//        System.out.println("boilingPoint = " + boilingPoint);
//        System.out.println("meltingPoint = " + meltingPoint);
        e.setMeltingPoint(meltingPoint);
        e.setBoilingPoint(boilingPoint);

        // state 이름을 얻어와 이름에 따라 상태 설정
        String stateName = jsonObject.get("state").getAsString();
        State<Element> state;
        switch (stateName.toLowerCase()) {
            case "gas":
                state = new GasState<>();
                break;
            case "liq":
                state = new LiquidState<>();
                break;
            case "solid":
                state = new SolidState<>();
                break;
            case "artificial":
                state = new ArtificialState<>();
                break;
            default:
                throw new IllegalArgumentException("Unknown state name: " + stateName);
        }
        e.setState(state);

        // 완성된 Element 반환
        return e;
    }
}