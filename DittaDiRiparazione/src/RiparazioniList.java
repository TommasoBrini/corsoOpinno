import java.util.Arrays;

public class RiparazioniList {
    private Riparazione[] myList;

    public RiparazioniList() {
        myList = new Riparazione[0];
    }

    public Riparazione get(int i) {
        return myList[i];
    }

    public Riparazione[] getMyList(){
        return myList;
    }

    public int indexOf(Riparazione i) {
        for (int j = 0; j < myList.length; j++) {
            if (myList[j] == i) {
                return j;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "MyListDiRiparazione{" +
                "myList=" + Arrays.toString(myList) +
                '}';
    }

    public int length() {
        return myList.length;
    }

    public boolean contains(Riparazione i) {
        return this.indexOf(i) >= 0;
    }

    public void add(Riparazione intero) {
        Riparazione[] newList = new Riparazione[myList.length + 1];
        System.arraycopy(myList, 0, newList, 0, myList.length);
        newList[newList.length - 1] = intero;
        myList = newList;
    }
}
