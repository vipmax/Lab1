import java.util.List;

/**
 * Created by magistr on 16.10.2015.
 */
public class Waiter {
    List<Fork> forks;
    public Waiter(List<Fork> forks) {
        this.forks = forks;
    }
    public boolean getAccess() {
        return (forks.size() < 4);
    }
}
