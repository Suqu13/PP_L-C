package List_8.zad_1;

import java.util.ArrayList;
import java.util.List;

public class cyclistQueue<E> implements MyQueue<E> {

    private int f;
    private int r;
    private int size;
    private List<E> queue;

    public cyclistQueue(int size) {
        f = 0;
        r = 0;
        this.size = size + 1;
        queue = new ArrayList<>();
    }

    @Override
    public void enqueue(E x) throws FullException {
        if ((r + 1) % size == f) {
            throw new FullException();
        } else {
            queue.add(r, x);
            r = (r + 1) % size;
        }
    }

    @Override
    public void dequeue() {
        if (f != r) {
            f = (f + 1) % size;
        }
    }

    @Override
    public E first() throws EmptyException {
        if (f == r) {
            throw new EmptyException();
        } else {
            return queue.get(f);
        }
    }

    @Override
    public boolean isEmpty() {
        return f == r;
    }

    @Override
    public boolean isFull() {
        return (r + 1) % size == f;
    }
}
