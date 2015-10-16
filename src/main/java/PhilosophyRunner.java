import java.util.ArrayList;
import java.util.List;

public class PhilosophyRunner {
    public static void main(String[] args) {
        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);
        Fork fork4 = new Fork(4);
        Fork fork5 = new Fork(5);

        List<Fork> forks = new ArrayList<>();
        Waiter waiter = new Waiter(forks);

        new Thread(new Philosopher(fork5, fork1, waiter),"1").start();
        new Thread(new Philosopher(fork1, fork2, waiter),"2").start();
        new Thread(new Philosopher(fork3, fork2, waiter),"3").start();
        new Thread(new Philosopher(fork3, fork4, waiter),"4").start();
        new Thread(new Philosopher(fork5, fork4, waiter),"5").start();

    }
}
