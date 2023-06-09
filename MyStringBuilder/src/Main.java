// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        MyStringBuilder msb = new MyStringBuilder();

        msb.append("Facilissimo")
                .append(" concatenare")
                .append(" stringhe!");

        MyString myFinalString = msb.build();

        System.out.println(myFinalString.getMyString().equals("Facilissimo concatenare stringhe!"));
        System.out.println(myFinalString.getMyString());
    }
}