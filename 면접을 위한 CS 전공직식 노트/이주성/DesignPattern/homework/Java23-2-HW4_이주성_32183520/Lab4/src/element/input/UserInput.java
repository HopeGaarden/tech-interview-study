package element.input;

import element.decorators.ElementDecorator;
import element.decorators.SymbolDecorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserInput {
    public static List<Decorator> getDecorators() {
        // InputStreamReader를 BufferedReader로 데코레이트
        // 사용자 입력으로 받은 문자 데이터를 버퍼링해 읽기 기능 향상
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 데코레이터 리스트
        List<Decorator> decorators = new ArrayList<>();

        System.out.println("데코레이터 종류: ");
        System.out.println("1. SymbolDecorator");
        System.out.println("2. WeightDecorator");
        System.out.println("3. PeriodDecorator");
        System.out.println("4. GroupDecorator");
        System.out.println("5. PhaseDecorator");
        System.out.println("6. TypeDecorator");
        System.out.print("추가하고 싶은 순서대로 데코레이터의 번호를 공백을 기준으로 입력해주세요: ");

        try {
            // 공백을 기준으로 입력받은 문자열 분리
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            while (st.hasMoreTokens()) {
                String d = st.nextToken();

                switch (d) {
                    case "1":
                        decorators.add(Decorator.SymbolDecorator);
                        break;
                    case "2":
                        decorators.add(Decorator.WeightDecorator);
                        break;
                    case "3":
                        decorators.add(Decorator.PeriodDecorator);
                        break;
                    case "4":
                        decorators.add(Decorator.GroupDecorator);
                        break;
                    case "5":
                        decorators.add(Decorator.PhaseDecorator);
                        break;
                    case "6":
                        decorators.add(Decorator.TypeDecorator);
                        break;
                    default:
                        System.out.println("유효하지 않은 선택입니다.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return decorators;
    }
}
