package template.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumSet;

public class UserInput {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int getIntegerBetween(int min, int max) {
        int num;

        while (true) {
            try {
                num = Integer.parseInt(br.readLine());

                if (num >= min && num <= max) {
                    break;
                } else {
                    System.out.print(min + "과 " + max + " 사이의 값을 입력해주세요: ");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return num;
    }
    public static int[] getIntegerArrayBetween(int min, int max) {
        int[] numbers;

        while (true) {
            try {
                // 공백을 기준으로 입력받아 int[]로 변환
                numbers = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                boolean flag = false;

                for (int num : numbers) {
                    if (num < min || num > max) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    System.out.print("1~118 사이의 번호만 입력해주세요. 다시 입력해주세요: ");
                    continue;
                }

                return numbers;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getPhase() {
        String input = null;

        while (true) {
            try {
                input = br.readLine();

                if (!input.isEmpty()) {
                    for (Phase p : Phase.values()) {
                        if (p.toString().equals(input)) {
                            return input;
                        }
                    }
                    System.out.print("gas, liq, solid, artificial 중 하나를 입력해주세요: ");
                } else {
                    System.out.print("다시 입력해주세요: ");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String[] getStringArray() {
        String[] inputs;

        while (true) {
            try {
                inputs = br.readLine().split(" ");

                if (inputs.length == 0) {
                    System.out.println("다시 입력해주세요: ");
                } else {
                    return inputs;
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int getNullOrIntegerBetween(int min, int max) {
        int num;

        while (true) {
            try {
                String input = br.readLine();

                // null일 경우 0 반환
                if (input.isEmpty()) {
                    num = 0;
                    break;
                }
                num = Integer.parseInt(input);

                if (num >= min && num <= max) {
                    break;
                } else {
                    System.out.print(min + "과 " + max + " 사이의 값을 입력해주세요: ");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return num;
    }

    public static String getStringNullable() {
        String input = null;

        while (true) {
            try {
                input = br.readLine();
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return input;
    }
}
