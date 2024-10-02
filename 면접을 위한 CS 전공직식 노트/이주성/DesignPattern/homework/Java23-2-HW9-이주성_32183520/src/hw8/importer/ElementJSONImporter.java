package hw8.importer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import hw8.periodic.Element;
import hw8.deserializer.DoubleOptionalDeserializer;
import hw8.deserializer.ElementDeserializer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class ElementJSONImporter implements FileImporter<Element> {

    @Override
    public List<Element> importFile(String filepath) {
        // 반환할 Element 객체 리스트
        List<Element> list = new ArrayList<>();

        // Optional<Double>을 직접 타입으로 사용할 수 없기 따로 타입으로 선언
        Type doubleOptionalType = new TypeToken<Optional<Double>>() {}.getType();

        // Deserializer 생성
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Element.class, new ElementDeserializer())
                .registerTypeAdapter(doubleOptionalType, new DoubleOptionalDeserializer())
                .create();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            // JSON 문자열을 List<Element>으로 역직렬화.
            Type listType = new TypeToken<List<Element>>() {}.getType();
            List<Element> elist = gson.fromJson(br, listType);

            // 반환할 리스트에 전부 추가
            list.addAll(elist);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // 리스트 반환
        return list;
    }

    @Override
    public void exportFile(String filepath, List<Element> list) {

    }
}
