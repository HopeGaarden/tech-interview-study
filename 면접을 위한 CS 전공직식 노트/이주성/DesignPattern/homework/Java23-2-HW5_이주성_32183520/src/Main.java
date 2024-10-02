/*
 * 과목: 자바프로그래밍2
 * 교수님: 박경신 교수님
 * 이름: 이주성
 * 학과: 컴퓨터공학과
 * 학번: 32183520
 * */

import element.Element;
import element.factory.PhaseElementFactory;
import element.phase.*;
import input.UserInput;
import periodic.PeriodicElement;
import periodic.PeriodicElementImporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Class<?> getClass(Phase phase) {
        switch (phase) {
            case gas:
                return GasElement.class;
            case liq:
                return LiquidElement.class;
            case solid:
                return SolidElement.class;
            case artificial:
                return ArtificialElement.class;
            default:
                return Object.class;
        }
    }

    public static void main(String[] args) throws IOException {

        // PeriodicElements.csv 파일을 load해서 PeriodicElement 리스트로 저장
        List<PeriodicElement> peList = PeriodicElementImporter.loadCSV("PeriodicElements.csv");

        // peList를 for 문으로 돌면서 Element를 생성한 후 elements에 add
        List<Element> elements = new ArrayList<>();
        for (PeriodicElement element : peList) {
            // Element 생성 부분은 팩토리 패턴을 적용해 캡슐화
            elements.add(PhaseElementFactory.getInstance(element.getNumber(), element.getName(), element.getSymbol(), element.getWeight(), element.getPhase()));
        }

        // quit로 종료 요청시까지 반복
        while (true) {
            // 유저에게 String 값을 입력받아 Phase 값으로 변환
            Phase phase = Phase.names(UserInput.getString());

            // quit 입력시 무한 루프 탈출
            if (phase == null) {
                System.out.println("검색을 종료합니다.\n");
                break;
            }

            System.out.println("===== Start Searching =====");
            // 입력받은 phase 값에 따른 class와 elements의 클래스가 동일한 값 필터링한 후 새로운 배열로 생성
            Element[] array = elements.stream()
                    .filter(e -> e != null && e.getClass().equals(getClass(phase)))
                    .toArray(Element[]::new);

            for (Element e : array) {
                System.out.println(e.toString());
            }

            System.out.println("===== End Searching =====\n");
        }


    }
}