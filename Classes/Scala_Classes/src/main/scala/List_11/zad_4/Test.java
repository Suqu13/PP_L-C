package List_11.zad_4;

import java.util.concurrent.Semaphore;

public class Test {
    public static void main(String[] args) {
        final Semaphore waiter = new Semaphore(4, true);

        final Fork[] forks = {new Fork(),
                new Fork(),
                new Fork(),
                new Fork(),
                new Fork()};

        final Philosopher[] philosophers = {new Philosopher("First", waiter, forks[0], forks[1]),
                new Philosopher("Second", waiter, forks[1], forks[2]),
                new Philosopher("Third", waiter, forks[2], forks[3]),
                new Philosopher("Fourth", waiter, forks[3], forks[4]),
                new Philosopher("Fifth", waiter, forks[4], forks[0])};

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}
