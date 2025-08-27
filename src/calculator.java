import java.util.InputMismatchException;
import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1 = 0.0; // 변수 초기화
        boolean check = false; // 입력 성공 여부를 판단하는 변수

        // 무한 루프를 통해 계속해서 계산기 기능을 제공
        do {
            System.out.println("간단한 계산기 프로그램입니다");

            // 첫 번째 숫자 입력
            while (!check) { // check가 false인 동안 (즉, 입력이 성공할 때까지) 반복
                try {
                    System.out.println("첫 번째 숫자를 입력하세요");
                    num1 = sc.nextDouble(); // 숫자를 입력받음
                    check = true; // 입력 성공 시 check를 true로 변경하여 루프를 탈출
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 숫자만 입력하세요");
                    sc.nextLine(); // 버퍼에 남아있는 잘못된 입력 값을 비워줌
                }
            }

            // 첫 번째 숫자 입력이 성공하면 다음 단계로 진행
            System.out.println("연산자를 입력하세요 (+, -, *,/)");
            String operation = sc.next();

            System.out.println("두 번째 숫자를 입력하세요");
            double num2;

            // 두 번째 숫자 입력 (두 번째 숫자도 예외 처리 필요)
            while (true) { // 두 번째 숫자 입력 루프
                try {
                    num2 = sc.nextDouble();
                    break; // 입력 성공 시 루프 탈출
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 숫자만 입력하세요");
                    sc.nextLine(); // 버퍼 비우기
                }
            }

            double result = 0;

            // 입력된 연산자에 따라 계산 수행
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    System.out.println(num1 + " + " + num2 + " = " + result);
                    break;
                case "-":
                    result = num1 - num2;
                    System.out.println(num1 + " - " + num2 + " = " + result);
                    break;
                case "*":
                    result = num1 * num2;
                    System.out.println(num1 + " * " + num2 + " = " + result);
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println(num1 + " / " + num2 + " = " + result);
                    } else {
                        System.out.println("오류: 0으로 나눌 수 없습니다.");
                        // 오류 발생 시 프로그램을 종료하지 않고 다음 계산으로 넘어가는 것이 더 사용자 친화적일 수 있습니다.
                    }
                    break;
                default:
                    System.out.println("오류!!! 올바른 연산자를 입력하세요");
                    // 잘못된 연산자 입력 시에도 다음 계산으로 넘어가도록 수정
                    break;
            }

            check = false; // 다음 계산을 위해 check를 다시 false로 초기화

        } while (true); // 무한 반복
        // sc.close(); // 무한 루프에서는 Scanner를 닫지 않습니다.
    }
}