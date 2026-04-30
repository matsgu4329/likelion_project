package policy;

public class AlumniPolicy implements Policy {
    @Override
    public boolean isPossible(int batch) {
        if (batch >= 10) {
            return true;
        } else {
            return false;
        }
    }
}
