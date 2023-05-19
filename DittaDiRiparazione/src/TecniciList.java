import java.util.Arrays;

public class TecniciList {
        private Tecnico[] myList;

        public TecniciList() {
            myList = new Tecnico[0];
        }

        public Tecnico[] getMyList(){
            return myList;
        }

        public Tecnico get(int i){
            return myList[i];
        }

        public int indexOf(Tecnico i){
            for(int j=0; j< myList.length; j++){
                if(myList[j]==i){
                    return j;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return "MyListDiTecnici{" +
                    "myList=" + Arrays.toString(myList) +
                    '}';
        }

        public int length(){
            return myList.length;
        }

        public boolean contains(Tecnico i){
            return this.indexOf(i) >= 0;
        }

        public void add(Tecnico intero){
            Tecnico[] newList = new Tecnico[myList.length+1];
            System.arraycopy(myList, 0, newList, 0, myList.length);
            newList[newList.length - 1] = intero;
            myList = newList;
        }

}
