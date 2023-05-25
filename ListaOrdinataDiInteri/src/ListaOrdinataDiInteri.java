import java.util.Arrays;
import java.util.Comparator;

import java.util.Arrays;

public class ListaOrdinataDiInteri extends ListaDiInteri {

    public ListaOrdinataDiInteri() {
        lunghezza=0;
        lista= new int[0];
    }

    public void add(int k) {
        boolean aggiunta = false;
        lunghezza++;
        int[] listaAdd = new int[lunghezza];
        for (int i = 0, j = 0; i < lunghezza; i++) {
            if (lista.length > j) {
                if (aggiunta == false && lista[j] > k) {
                    listaAdd[i] = k;
                    aggiunta = true;
                } else {

                    listaAdd[i] = lista[j];
                    j++;

                }
            } else {
                listaAdd[i] = k;
            }
        }
        this.lista = listaAdd;
    }

    public void add(int indice,int k){
        if(lista[indice-1]<k&&k<lista[indice]){
            lunghezza++;
            int[] listaAdd = new int[lunghezza];
            for (int i=0,j=0;i<lunghezza;i++,j++){
                if(i==indice){
                    listaAdd[i]=k;
                    j--;
                }else {
                    listaAdd[i] = lista[j];
                }
            }
            this.lista=listaAdd;

        }
    }

    public void addlast(int k){
        if(lista[lunghezza-1]<k){
            int[] listaAdd= new int[lunghezza+1];
            for (int i=0;i<lunghezza;i++){
                listaAdd[i]=lista[i];
            }
            listaAdd[lunghezza]=k;
            lunghezza++;
            this.lista=listaAdd;
        }
    }
    @Override
    public Integer get(int i) {
        return lista[i];
    }

    public boolean contains(int i) {
        for(int j=0;j<lunghezza;j++){
            if(lista[j]==i){
                return true;
            }
        }
        return false;
    }


    public int indexOf(int i) {
        for(int j=0;j<lunghezza;j++){
            if(lista[j]==i){
                return j;
            }
        }
        return -1;
    }
    public int length() {
        return lunghezza;
    }

    @Override
    public String toString() {
        return "ListaOrdinataDiInteri{" +
                "lista=" + Arrays.toString(lista) +
                '}';
    }
}

