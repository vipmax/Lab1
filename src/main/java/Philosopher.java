
import java.util.Random;

public class Philosopher implements Runnable {
    private Fork fork1;
    private Fork fork2;
    private Waiter waiter;

    public Philosopher(Fork fork1, Fork fork2, Waiter waiter) {
        this.fork1 = fork1;
        this.fork2 = fork2;
        this.waiter = waiter;
    }


    public void run() {
        while (true){
            eat();
            think();
        }
    }

    private void eat() {
        if (waiter.getAccess()) {
            fork1.get();
            fork2.get();
            try {
                System.out.println("Philosopher " + Thread.currentThread().getName() + " is eating!");

                Thread.sleep(new Random().nextInt(1000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fork1.put();
            fork2.put();
        }
    }

    private void think() {
        try {
            System.out.println("Philosopher " + Thread.currentThread().getName() + " is thinking!");
            Thread.sleep(new Random().nextInt(1000) + 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
