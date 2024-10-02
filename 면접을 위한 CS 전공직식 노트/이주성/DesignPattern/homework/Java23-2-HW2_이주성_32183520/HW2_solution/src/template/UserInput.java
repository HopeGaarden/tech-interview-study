package template;

import template.finder.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInput {
    // InputStreamReader를 BufferedReader로 데코레이트
    // 문자 데이터를 버퍼링해 읽기 기능 향상
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

    public static String getString() {
        String input = null;

        while (true) {
            try {
                input = br.readLine();

                if (!input.isEmpty()) {
                    break;
                } else {
                    System.out.print("다시 입력해주세요: ");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return input;
    }

    public static double getDouble() {

        double mass;

        while (true) {
            try {
                mass = Double.parseDouble(br.readLine());
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return mass;
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

    public static String getStringNullalbe() {
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

    public static IPeriodicElementFinder getFilter() {

        while (true) {
            System.out.println("검색 방법: ");
            System.out.println("1. Number");
            System.out.println("2. Name");
            System.out.println("3. Symbol");
            System.out.println("4. Mass");
            System.out.println("5. Period");
            System.out.println("6. Group");
            System.out.println("7. Phase");
            System.out.println("8. Type");
            System.out.println("0. 종료"); // 검색 종료 옵션 추가
            System.out.print("검색 방법을 번호로 선택해주세요 (0을 입력하면 종료): ");

            int input = 0;
            try {
                input = Integer.parseInt(br.readLine());

                switch (input) {
                    case 0:
                        System.out.println("검색을 종료합니다.");
                        return null;
                    case 1:
                        return new NumberFinder();
                    case 2:
                        return new NameFinder();
                    case 3:
                        return new SymbolFinder();
                    case 4:
                        return new MassFinder();
                    case 5:
                        return new PeriodFinder();
                    case 6:
                        return new GroupFinder();
                    case 7:
                        return new PhaseFinder();
                    case 8:
                        return new TypeFinder();
                    default:
                        System.out.println("유효하지 않은 선택입니다. 다시 선택해주세요.");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
