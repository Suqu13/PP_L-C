package List_9;

public class Test {
    public static void main(String[] args) {
        Animals animals = new Animals("animal", 5);
        Dog dog = new Dog("dog", 4);
        Number heightA = animals.getHeight();
        System.out.println(heightA);
        animals = new Dog("ADog", 6);
        heightA = animals.getHeight();
        System.out.println(heightA);
    }
}
