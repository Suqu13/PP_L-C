package List_8.zad_1;

public class test {
    public static void main(String[] args) throws FullException, EmptyException {
        MyQueue queue = new cyclistQueue(3);
        queue.enqueue("kot");
        queue.enqueue("pies");
        queue.enqueue("krowa");
        System.out.println(queue.first());
        queue.dequeue();
        queue.enqueue("owca");
        System.out.println(queue.first());
        queue.dequeue();
        queue.enqueue("kangur");
        System.out.println(queue.first());
        queue.enqueue("cokolwiek");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.first());

    }
}
