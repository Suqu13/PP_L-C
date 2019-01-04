package List_8.zad_2;

public class Test {
    int zawartość = 0;

    /* Podczas gdy "zmienna" jest referencja do obiektu przekazywanego do metody
     * i nie może zacząć wskazywac na inny obiekt, to zawartość tego obiektu może
     * ulec zmianie. Tyczy sę to obiektów finalnych jak i zwykłych. */

    static void argNiemodyfikowalny(final Test zmienna) {
        zmienna.zawartość = 1;
        //zmienna = null;
    }

    /* Argument przekazany jest przez referencję co oznacza że "zmienna" jest
     * tylko referencją do obiektu i przypisywanie jest wartości null spowoduje,
     * że nie będzie wskazywała już na ten obiekt, natiomiast sam obiekt w tym
     * momencie pozostanie w pamięci */

    static void argModyfikowalny(Test zmienna) {
        zmienna.zawartość = 1;
        zmienna = null;
    }

    public static void main(String[] args) {
        Test modyfikowalna = new Test();
        final Test niemodyfikowalna = new Test();
        argModyfikowalny(modyfikowalna);
        System.out.println(niemodyfikowalna.zawartość);
    }


    //BEZ USUWANIA BŁEDU Z PIERWSZEJ METODY: Error:(7, 9) java: final parameter zmienna may not be assigned
    //a) argNiemodyfikowalny(modyfikowalna);
    //   System.out.println(modyfikowalna.zawartość);
    //   1
    //b) argNiemodyfikowalny(niemodyfikowalna);
    //   System.out.println(niemodyfikowalna.zawartość);
    //   1
    //c) argModyfikowalny(modyfikowalna);
    //   System.out.println(modyfikowalna.zawartość);
    //   1
    //d) argModyfikowalny(niemodyfikowalna);
    //   System.out.println(niemodyfikowalna.zawartość);
    //   1

}
