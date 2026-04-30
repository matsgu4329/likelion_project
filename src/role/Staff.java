package role;

import policy.StaffPolicy;

public class Staff extends Role {
    String position;

    public Staff(String name, String major, int batch, String part, String position) {
        super(name, major, batch, part);
        this.position = position;
    }

    @Override
    StaffPolicy getObj() {
        return new StaffPolicy();
    }

    @Override
    public void show() {
        System.out.println("역할: 운영진");
        System.out.println("이름: " + this.getName() + ", 전공: " + this.getMajor() + ", 기수: " + this.getBatch() + ", 파트: " + this.getPart());
        System.out.println("직책: " + this.position);
        System.out.println("과제 제출 가능 여부: " + isSub());
    }
}
