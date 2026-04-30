package policy;

public class StaffPolicy implements Policy {
    @Override
    public boolean isPossible(int batch) {
        if (batch >= 10) {
            return true;
        } else {
            return false;
        }
    }
}
