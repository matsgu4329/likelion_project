package role;

import policy.LionPolicy;
import policy.Policy;

public abstract class Role {
    private String name;
    private String major;
    private int batch;
    private String part;

    public Role(String name, String major, int batch, String part) {
        this.name = name;
        this.major = major;
        this.batch = batch;
        this.part = part;
    }

    abstract Policy getObj();

    abstract public void show();
    String getName() {
        return this.name;
    };
    String getMajor() {
        return this.major;
    };
    String getPart() {
        return this.part;
    };
    int getBatch() {
        return this.batch;
    };

    String isSub() {
        if (getObj().isPossible(this.getBatch())) {
            return "가능";
        } else {
            return "불가능";
        }
    }
}
