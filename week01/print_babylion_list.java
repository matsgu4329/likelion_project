import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListPrint {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String go;
        int listSize;

        while(true) {
            while (true) {
                System.out.print("아기사자 수를 5이상 입력하세요: ");
                try {
                    listSize = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("[오류] 숫자만 입력할 수 있습니다.");
                    sc.next();
                    continue;
                }
                if (listSize >= 5) {
                    break;
                } else {
                    System.out.println("아기사자 수는 5미만이 될 수 없습니다.");
                }
            }

            String[] babyLionArr = new String[listSize]; //명단 배열 크기로 배열 선언

            System.out.println("입력된 아기사자 수만큼 이름을 입력하세요.");
            sc.nextLine();

            int i = 0;

            while (i < listSize) {
                boolean check = false;
                System.out.print((i+1) + "번째 이름 입력: ");
                String babyLion = sc.nextLine();

                if (babyLion.isEmpty()) {
                    System.out.println("이름이 비어있습니다. 다시 입력해주세요.");
                    continue;
                }
                for (int j = 0; j < listSize; j++) {
                    if (babyLion.equals(babyLionArr[j])){
                        System.out.println("이미 등록된 이름입니다. 다시 입력해주세요");
                        check = true;
                        break;
                    }
                }
                if (check) {
                    continue;
                }
                babyLionArr[i] = babyLion;
                i++;
            }

            System.out.println("아기사자 명단을 출력합니다.");
            System.out.println("------------------------------");
            for (int j = 0; j < listSize; j++) {
                System.out.println((j+1) + ". " + babyLionArr[j]);
            }

            System.out.println("프로그램을 종료하려면 'exit'를 입력하세요.");
            System.out.println("계속 아기사자를 등록하려면 'restart'를 입력하세요.");
            go = sc.next();

            while (true) {
                if (go.equals("restart")) {
                    System.out.println("아기사자 등록을 재시작합니다.");
                } else if (go.equals("exit")){
                    System.out.println("아기사자 명단 관리 프로그램을 종료합니다.");
                    return;
                } else {
                    System.out.println("명령어를 다시 입력해주세요.");
                    break;
                }

            }

        }
    }
}
