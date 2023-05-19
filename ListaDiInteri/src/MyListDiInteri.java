import java.util.Arrays;

public class MyListDiInteri {
    private int[] myList;

    public MyListDiInteri() {
        myList = new int[0];
    }

    public int get(int i){
        return myList[i];
    }

    public int indexOf(int i){
        for(int j=0; j< myList.length; j++){
           if(myList[j]==i){
               return j;
           }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "MyListDiInteri{" +
                "myList=" + Arrays.toString(myList) +
                '}';
    }

    public int length(){
        return myList.length;
    }

    public boolean contains(int i){
        return this.indexOf(i) >= 0;
    }

    public void add(int intero){
        int[] newList = new int[myList.length+1];
        System.arraycopy(myList, 0, newList, 0, myList.length);
        newList[newList.length - 1] = intero;
        myList = newList;
    }

}
