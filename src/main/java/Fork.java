public class Fork {

    private int id;
    private boolean isUses;

    public Fork(int id) {
        isUses = false;
        this.id = id;
    }

    public void get(){
        synchronized (this) {
            while (isUses) {
                try {
                    System.out.println("Philosopher " + Thread.currentThread().getName() + " is waiting to get fork " + id);
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Philosopher " + Thread.currentThread().getName() + " get fork " + id);
            isUses = true;
            notify();
        }
    }

    public synchronized void put(){
        synchronized(this) {
            System.out.println("Philosopher " + Thread.currentThread().getName() + " put fork " + id);
            isUses = false;
            notify();
        }
    }
}
