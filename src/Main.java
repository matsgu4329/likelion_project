import role.Alumni;
import role.Lion;
import role.Role;
import role.Staff;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 아기사자 정보 입력 ===");
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("전공: ");
        String major = sc.nextLine();
        System.out.print("기수: ");
        int batch = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();
        System.out.print("학번: ");
        int studentID = sc.nextInt();
        sc.nextLine();

        Role L = new Lion(name, major, batch, part, studentID);

        System.out.println();

        System.out.println("=== 운영진 정보 입력 ===");
        System.out.print("이름: ");
        name = sc.nextLine();
        System.out.print("전공: ");
        major = sc.nextLine();
        System.out.print("기수: ");
        batch = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        part = sc.nextLine();
        System.out.print("직책 (대표/부대표/파트장/멘토): ");
        String position = sc.nextLine();

        Role S = new Staff(name, major, batch, part, position);

        System.out.println();

        System.out.println("=== 알럼나이 정보 입력 ===");
        System.out.print("이름: ");
        name = sc.nextLine();
        System.out.print("전공: ");
        major = sc.nextLine();
        System.out.print("기수: ");
        batch = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        part = sc.nextLine();
        System.out.print("현재 직무: ");
        String job = sc.nextLine();

        Role A = new Alumni(name, major, batch, part, job);

        System.out.println("=== 결과 출력 ===");
        L.show();
        System.out.println("----------------");
        S.show();
        System.out.println("----------------");
        A.show();

        sc.close();
    }
}
