package List_6;

public class zad_3_and_4_and_5 {

    public static class IsEqual {
        static boolean isEqual1(int m, int n) { // int - typ prymitywny
            return m == n;
        }

        static boolean isEqual2(Integer m, Integer n) { // Integer - klasa, pracuje na liczbach (cashowanie) -128 do 127 jako tablicy, do tych wartości zwraca ten sam obiekt,
                                                        // więc ich porównanie za pomocą operatora == ma sens, po przekroczeniu limitu zostanie zwrócony inny
                                                        // obiekt, z inną listą
            return m == n;
        }

        public static void main(String[] args) {
            System.out.println(isEqual1(500, 500));
            System.out.println(isEqual2(500, 500));
        }
    }

    public static class Porównanie {
        public static void main(String[] args) {
            String s1 = "foo"; // tworzy obiekt typu String
            String s2 = "foo"; // tworzy refeencje do obiektu s1
            System.out.println(s1 == s2); // == sprawdza czy s1 i s2 są zapisane w tym samym miejscu pamięci wirtualnej, TRUE
            System.out.println(s1.equals(s2)); // sprawdza równość dla wartosci znak po znaku, TRUE
            String s3 = new String("foo"); // tworzy obiekt s3, który zajmuje zupełnie inną przestrzeń pamięci, lecz posiada taką samą wartość
            System.out.println(s1 == s3); //  == sprawdza czy s1 i s3 są zapisane w tym samym miejscu pamięci wirtualnej, zupełnie inne przestrzenie w pamięci, FALSE
            System.out.println(s1.equals(s3)); // sprawdza równość dla wartosci znak po znaku, TRUE
        }
    }

    public static class Aliasy {
        public static void main(String[] args) {
            int[] ints = {1, 2, 3};
            for (int i : ints) { // maszyna wirtualna pamięta element, do którego się poprzednio odwoływała i rozpoczyna działanie od tego miejsca
                System.out.println(i);
                i = 0;
            }
            for (int i : ints)
                System.out.println(i);
            int[] ints2 = ints; // tworzy referecje na obiekt ints
            for (int i = 0; i < ints2.length; i++) {
                System.out.println(ints2[i]);
                ints2[i] = -1; // ints2 jest referencją do obiektu ints, zatem zmiana wartości w jednym z nich swpowduje zmianę w obu
            }
            for (int i : ints)
                System.out.println(i);
        }
    }
}
