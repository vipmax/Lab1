public class PhilosophyRunner {
    public static void main(String[] args) {
        Fork fork_1 = new Fork(1);
        Fork fork_2 = new Fork(2);
        Fork fork_3 = new Fork(3);
        Fork fork_4 = new Fork(4);
        Fork fork_5 = new Fork(5);

        new Thread(new Philosopher(fork_5, fork_1),"1").start();
        new Thread(new Philosopher(fork_1, fork_2),"2").start();
        new Thread(new Philosopher(fork_3, fork_2),"3").start();
        new Thread(new Philosopher(fork_3, fork_4),"4").start();
        new Thread(new Philosopher(fork_5, fork_4),"5").start();

    }
}
