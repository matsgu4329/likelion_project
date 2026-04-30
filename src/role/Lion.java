package role;

import policy.LionPolicy;

public class Lion extends Role{
    int studentID;

    public Lion(String name, String major, int batch, String part, int studentID) {
        super(name, major, batch, part);
        this.studentID = studentID;
    }

    @Override
    LionPolicy getObj() {
        return new LionPolicy();
    }

    @Override
    public void show() {
        System.out.println("역할: 아기사자");
        System.out.println("이름: " + getName() + ", 전공: " + getMajor() + ", 기수: " + getBatch() + ", 파트: " + getPart());
        System.out.println("학번: " + this.studentID);
        System.out.println("과제 제출 가능 여부(기수 10 이상 가능): " + isSub());
    }
}
