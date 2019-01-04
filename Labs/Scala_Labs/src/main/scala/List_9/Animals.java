package List_9;

public class Animals {
    private String name;
    public Number height;

    public Animals(String name, Number height) {
        this.name = name;
        this.height = height;
    }

    public Number getHeight() {
        return height;
    }
}

class Dog extends Animals {

    public Dog(String name, Number height) {
        super(name, height);
    }

    public Integer getHeight() {
        return (int) height;
    }

}
