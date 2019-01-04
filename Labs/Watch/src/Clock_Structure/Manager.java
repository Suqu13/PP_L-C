package Clock_Structure;

import Functions.Clock_Function.AbstractClock_Function;

public interface Manager {
    public abstract void callFunctions(AbstractClock_Function abstractClock_function);

    public abstract void show(String tittle);
}
