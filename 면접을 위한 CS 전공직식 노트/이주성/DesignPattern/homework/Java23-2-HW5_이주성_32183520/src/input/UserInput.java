package input;

import element.phase.Phase;

import java.io.*;
import static element.phase.Phase.names;

public class UserInput {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 조회하고 싶은 phase 값 입력받기
    public static String getString() throws IOException {
        // 입력받은 값이 Phase 타입에 존재할 때까지 무한 루프
        while (true) {
            System.out.print("조회하고 싶은 Phase를 입력하세요. (gas, liq, solid, artificial, quit(종료)) : ");
            String s = br.readLine();

            // 유효한 Phase 값이 아니면 null 반환
            Phase phase = names(s);

            if (phase != null) {
                return s;
            } else {
                if (s.equals("quit")) {
                    return null;
                }
                System.out.println("gas, liq, solid, artificial 중에서 하나를 입력해주세요. ");
            }
        }
    }
}
