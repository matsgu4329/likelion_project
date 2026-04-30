package role;

import policy.AlumniPolicy;
import policy.StaffPolicy;

public class Alumni extends Role {
    String job;

    public Alumni(String name, String major, int batch, String part, String job) {
        super(name, major, batch, part);
        this.job = job;
    }

    String getJob() {
        return job;
    }

    @Override
    AlumniPolicy getObj() {
        return new AlumniPolicy();
    }

    @Override
    public void show() {
        System.out.println("역할: 알럼나이");
        System.out.println("이름: " + this.getName() + ", 전공: " + this.getMajor() + ", 기수: " + this.getBatch() + ", 파트: " + this.getPart());
        System.out.println("현재 직무: " + this.job);
        System.out.println("과제 제출 가능 여부: " + isSub());
    }
}
