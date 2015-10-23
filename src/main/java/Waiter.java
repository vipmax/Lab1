import java.util.List;

/**
 * Created by magistr on 16.10.2015.
 */
public class Waiter {
    List<Fork> forks;
    public Waiter(List<Fork> forks) {
        this.forks = forks;
    }
    public boolean getAccess(Fork fork) {
        long countOfUsedForks = forks.stream().filter(f -> f.isUses()).count();
        boolean access = countOfUsedForks < 4;
        System.out.println("Philosopher " + Thread.currentThread().getName() + " asked fork " + fork.getId() + ". forks = " + forks + " access = " + access);
        return access;
    }
}
