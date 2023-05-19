public class Main {
    public static void main(String[] args) {
        MyListDiInteri lista = new MyListDiInteri();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        System.out.println(lista.length());
        System.out.println(lista.toString());
        System.out.println(lista.contains(3));
        System.out.println(lista.get(2));
        System.out.println(lista.indexOf(3));
    }
}