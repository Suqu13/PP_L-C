package List_11.zad_3;

public class BoundedBuffer implements Produce, Consume {
    final private int N;
    private int in = 0, out = 0, n = 0;
    private int[] elems; //TODO: Tablica na wartości

    public BoundedBuffer(int N) {
        this.N = N; elems = new int[N]; 
    }

    public synchronized void put(int x) {
        while (n >= N) //TODO: W momencie gdy tablica jest pełny wątek/ producent zostaje zablokowany, nie produkuje więcej elem, by nie przepełnić tablicy
          try {
        	  System.out.println(Thread.currentThread().getName()+" waiting with " + x); 
        	  wait(); 
          } catch (InterruptedException e) {System.out.println(e);}
        elems[in] = x; in = (in + 1) % N ; n += 1; //TODO: Wrzucenie watrości x do kontenera, wyliczenie następnego potencjalnego miejsca, inkrementacja aktualnie zajmowaego miejsca w tablicy
        System.out.println(Thread.currentThread().getName()+" produced: " + x);
        if (n == 1) notifyAll(); //TODO: Powiadomienie wszystkich producentów/ wątków iż należy wznowić produkcje
    }

    public synchronized int take() {
        while (n == 0) //TODO: W sytuacji gdy tablica jest pusty następuje uśpienie konsumenta/ wątku w celu zaprzestania dalszej konsumpcji
          try {
        	  System.out.println(Thread.currentThread().getName()+" waiting"); 
        	  wait(); 
          } catch (InterruptedException e) {System.out.println(e);}
        int x = elems[out]; out = (out + 1) % N ; n -= 1; //TODO: Przypisanie wartości x elementu z tablicay pod indeksem 'out', oblicznie następnego potencjalnego miejsca, dekrementacja rozmiaru
        System.out.println(Thread.currentThread().getName()+" consuming: " + x);
        if (n == N-1) notifyAll(); //TODO: Powiadomienie wszystkich konsumentów/ wątków iż należy wznowić konsumpcje
        return x;
    }
}

//TODO: Wykorzystywany buffor cykliczny
//TODO: Użycie notify() nie byłoby bezpieczne, gdyż musimy wtedy precyzować wątek który ma być wznowiony/ odblokowany.
//TODO: Nie mamy kontroli nad tym, które wątki są blokowane, więc byłoby to niewykonalne. Mogłoby dojść do bezpośredniego zakleszczenia