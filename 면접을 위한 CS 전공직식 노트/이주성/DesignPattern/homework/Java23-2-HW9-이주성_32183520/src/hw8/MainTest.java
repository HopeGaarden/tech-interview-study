package hw8;

import hw8.importer.ChemicalCompoundJSONImporter;
import hw8.importer.ElementJSONImporter;
import hw8.periodic.ChemicalCompound;
import hw8.periodic.Element;

import java.util.List;

/*
 * 과목: 자바프로그래밍2
 * 교수님: 박경신 교수님
 * 이름: 이주성
 * 학과: 컴퓨터공학과
 * 학번: 32183520
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println("\nload Element from json file");
        List<Element> list = new ElementJSONImporter().importFile("data/PeriodicElementsDetail.json");
//        for (Element e : list) { System.out.println(e.toString()); }

        // state change of Element at temperature 22 ~ 5000
        double temperature = 22;
        for (temperature = 22; temperature < 5000; temperature += 10) {
            System.out.println("\n\nElement state at temperature = " + temperature);
//            for (Element e: list) { e.setTemperature(temperature); }
            list.get(0).setTemperature(temperature);
        }

        // state change of Element at temperature 22 ~ -300
        for (temperature = 22; temperature > -300; temperature -= 10) {
            System.out.println("\n\nElement state at temperature = " + temperature);
//            for (Element e: list) { e.setTemperature(temperature); }
            list.get(0).setTemperature(temperature);
        }

        System.out.println("\nload ChemicalCompound from json file");
        List<ChemicalCompound> clist = new ChemicalCompoundJSONImporter().importFile("data/ChemicalCompoundDetail.json");
//        for (ChemicalCompound c : clist) {
//            System.out.println(c.toString());
//        }

        // state change of ChemicalCompound at 22C ~ 1500C & 22C ~ -300C
        for (temperature = 22; temperature < 1500; temperature += 10) {
            System.out.println("\n\nChemicalCompound state at temperature = " + temperature);
//            for (ChemicalCompound c: clist) { c.setTemperature(temperature); }
            clist.get(0).setTemperature(temperature);
        }

        // state change of Element at temperature 22 ~ -300
        for (temperature = 22; temperature > -300; temperature -= 10) {
            System.out.println("\n\nChemicalCompound state at temperature = " + temperature);
//            for (ChemicalCompound c: clist) { c.setTemperature(temperature); }
            clist.get(0).setTemperature(temperature);
        }
    }
}
