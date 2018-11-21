package List_6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class zad_1 {
    static <T extends Comparable> T[] insert(T[] tab, T toInsert) {
        T[] array = (T[]) Array.newInstance(tab.getClass().getComponentType(), tab.length + 1);
        int k = 0;
        for (int i = 0; i < tab.length && tab[i].compareTo(toInsert) < 0; i++) {
            array[i] = tab[i];
            k = i;
        }
        array[k] = toInsert;
        for (int i = k; i < tab.length; i++) {
            array[i + 1] = tab[i];
        }
        return array;
    }

    public static void main(String[] args) {
        Integer a[] = {-11, -3, 25, 79};
        System.out.println(Arrays.toString(insert(a, -14)));
        System.out.println(Arrays.toString(insert(a, 0)));
        System.out.println(Arrays.toString(insert(a, 80)));
        System.out.println(Arrays.toString(insert(a, 3)));
    }
}