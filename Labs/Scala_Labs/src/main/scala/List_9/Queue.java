package List_9;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private List<T> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public T first() {
        return queue.get(0);
    }

    public T last() {
        return queue.get(queue.size() - 1);
    }

    public void enqueue(T x) {
        queue.add(0, x);
    }

    public void dequeue() {
        queue.remove(queue.size() - 1);
    }
}

class main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println(queue.isEmpty());
        queue.enqueue("String");
        queue.enqueue(5);
        queue.enqueue('a');
        queue.enqueue(0.56);
        queue.enqueue(new Queue<>());
        System.out.println(queue.first());
        System.out.println(queue.last());
        System.out.println(queue.isEmpty());
        queue.dequeue();
        System.out.println(queue.last());
    }
}
