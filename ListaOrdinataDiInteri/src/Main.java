// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ListaOrdinataDiInteri lista = new ListaOrdinataDiInteri();
        lista.add(4);
        lista.add(3);
        lista.add(2);
        lista.add(10);
        lista.add(5);
        lista.add(1);

        System.out.println(lista);

        lista.add(5, 8);

        lista.addlast(7);
        lista.addlast(70);
        System.out.println(lista);
    }
}