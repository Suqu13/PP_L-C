package Functions.Clock_Function;

abstract public class AbstractClock_Function {

    private String tittle;

    AbstractClock_Function(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle(){
        return tittle;
    }

    public abstract void addAction();
    public abstract void changeDetails();
    public abstract void showActions();
    public abstract void runFunction();
}
