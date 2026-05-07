import role.Alumni;
import role.Lion;
import role.Role;
import role.Staff;

import java.util.*;

class Person implements Comparable<Person> {
    String name;
    int batch;

    Person(String name, int batch) {
        this.name = name;
        this.batch = batch;
    }

    @Override
    public int compareTo(Person other) {
        return this.batch - other.batch;
    }
}

class Manager {
    public static List<Role> list = new ArrayList<>();
    public static Map<String, List<Role>> partMap = new HashMap<>();
    public static List<Person> personList = new ArrayList<>();


    static void displayCMD() {
        System.out.println("--------------------------------");
        System.out.println("1. 아기사자 정보 입력");
        System.out.println("2. 운영진 정보 입력");
        System.out.println("3. 알럼나이 정보 입력");
        System.out.println("4. 전체 멤버 목록 출력");
        System.out.println("5. 이름으로 멤버 검색");
        System.out.println("6. 파트 종류 조회하기");
        System.out.println("7. 파트명으로 멤버 검색");
        System.out.println("8. 이름으로 멤버 삭제");
        System.out.println("9. 파트별 통계 출력");
        System.out.println("10. 종료");
        System.out.println("--------------------------------");
    }

    static void babyLion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 아기사자 정보 입력 ===");
        System.out.print("이름: ");
        String name = sc.nextLine();

        if (Manager.isInList(name)) {
            return;
        }

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
        list.add(L);
        Person perL = new Person(name, batch);
        personList.add(perL);

        // part가 없으면 new ArrayList<>()를 생성해 Map에 넣고, 그 리스트를 반환함
        // 반환된 리스트(기존 리스트 혹은 새 리스트)에 바로 add 실행
        partMap.computeIfAbsent(part, k -> new ArrayList<>()).add(L);
    }

    static void staff() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 운영진 정보 입력 ===");
        System.out.print("이름: ");
        String name = sc.nextLine();

        if (Manager.isInList(name)) {
            return;
        }

        System.out.print("전공: ");
        String major = sc.nextLine();
        System.out.print("기수: ");
        int batch = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();
        System.out.print("직책 (대표/부대표/파트장/멘토): ");
        String position = sc.nextLine();

        Role S = new Staff(name, major, batch, part, position);
        list.add(S);
        Person perL = new Person(name, batch);
        personList.add(perL);

        partMap.computeIfAbsent(part, k -> new ArrayList<>()).add(S);
    }

    static void alumni() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 알럼나이 정보 입력 ===");
        System.out.print("이름: ");
        String name = sc.nextLine();

        if (Manager.isInList(name)) {
            return;
        }

        System.out.print("전공: ");
        String major = sc.nextLine();
        System.out.print("기수: ");
        int batch = sc.nextInt();
        sc.nextLine();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();
        System.out.print("현재 직무: ");
        String job = sc.nextLine();

        Role A = new Alumni(name, major, batch, part, job);
        list.add(A);
        Person perL = new Person(name, batch);
        personList.add(perL);

        partMap.computeIfAbsent(part, k -> new ArrayList<>()).add(A);
    }

    static void printAll() { //전체 멤버 조회
        Collections.sort(personList);

        for (Person per : personList) {
            for (Role role : list) {
                if (Objects.equals(per.name, role.getName())) {
                    role.show();
                    System.out.println();
                }
            }
        }
    }

    static void searchName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 이름 입력: ");
        String name = sc.nextLine();

        System.out.println("[이름 검색 결과]");
        for (Role role : list) {
            if (Objects.equals(role.getName(), name)) {
                role.show();
            }
        }
    }

    static void printAllPart() {
        System.out.println("[파트 조회]");
        for (String part : partMap.keySet()) {
            System.out.println(part);
        }
    }

    static void searchPart() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 파트 입력: ");
        String input_part = sc.nextLine();

        System.out.println("[파트 검색 결과]");
        for (String partName : partMap.keySet()) {
            if (Objects.equals(partName, input_part)) {
                for (Role role : partMap.get(partName)) {
                    role.show();
                }
            }
        }
    }

    static boolean isInList(String name) {
        for (Role role : list) {
            if (Objects.equals(role.getName(), name)) {
                System.out.println("등록 실패: 이미 존재하는 이름입니다.");
                return true;
            }
        }
        return false;
    }

    static void delMember() {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 이름 입력: ");
        String name = sc.nextLine();

        list.removeIf(role -> Objects.equals(role.getName(), name));
        for (int i=0; i < partMap.size(); i++) {
            for (List<Role> role : partMap.values()) {
                if (Objects.equals(role.get(i).getName(), name)) {
                    role.remove(i);
                }
            }
        }
        personList.removeIf(per -> Objects.equals(per.name, name));

        System.out.println("삭제 완료: " + name);
    }

    static void partInfo() {
        System.out.println("파트별 통계");
        int backendCnt = 0;
        int frontendCnt = 0;
        int designCnt = 0;
        int gihooekCnt = 0;

        for (String part : partMap.keySet()) {
            if (Objects.equals(part, "백엔드")) {
                backendCnt++;
            } else if (Objects.equals(part, "프론트엔드")) {
                frontendCnt++;
            } else if (Objects.equals(part, "디자인")) {
                designCnt++;
            } else if (Objects.equals(part, "기획")) {
                gihooekCnt++;
            }
        }
        int total = backendCnt + frontendCnt + designCnt + gihooekCnt;

        System.out.println("백엔드: " + backendCnt + "명");
        System.out.println("프론트엔드: " + frontendCnt + "명");
        System.out.println("디자인: " + designCnt + "명");
        System.out.println("기획: " + gihooekCnt + "명");
        System.out.println("---------------------------------");
        System.out.println("총합: " + total + "명");
    }
}

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cmd = -1;

        while (cmd != 10) {
            Manager.displayCMD();
            System.out.print("번호를 선택하세요 (1-6): ");
            cmd = sc.nextInt();
            sc.nextLine();

            switch (cmd) {
                case 1:
                    Manager.babyLion();
                    break;
                case 2:
                    Manager.staff();
                    break;
                case 3:
                    Manager.alumni();
                    break;
                case 4:
                    Manager.printAll();
                    break;
                case 5:
                    Manager.searchName();
                    break;
                case 6:
                    Manager.printAllPart();
                    break;
                case 7:
                    Manager.searchPart();
                case 8:
                    Manager.delMember();
                    break;
                case 9:
                    Manager.partInfo();
                    break;
                case 10:
                    break;
            }
        }
        sc.close();
    }
}
