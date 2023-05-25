import java.util.Arrays;

public class ListaDiInteri {

    protected int[] lista = new int[0];

    protected int lunghezza = 0;

    public ListaDiInteri() {}

    public ListaDiInteri(int[] values) {
        for (int value : values){
            lunghezza++;
            add(value);
        }
    }


    /**
     * @return lunghezza della lista di interi
     */
    public int length() { return lista.length; }

    /**
     * Aggiunge un valore nella lista di interi, estendendo la dimensione dell'array di 1
     *
     * @param value l'intero da aggiungere alla lista
     */
    public void add(int value) {
        // estendiamo l'array di interi creandone uno nuovo temporaneo di lunghezza maggiore di 1
        // così da poter aggiungere un nuovo valore
        int[] tmp = new int[lista.length + 1];
        // copiamo ogni intero nel nuovo array esteso di lunghezza
        for (int i = 0; i < lista.length; i++)
            tmp[i] = lista[i];
        // aggiungiamo il nuovo valore in ultima posizione
        tmp[lista.length] = value;
        // salviamo nel campo values il riferimento in memoria dell'array esteso con il nuovo valore
        lista = tmp;
    }

    /**
     * Ritorna il valore all'indice in input
     *
     * @param i indice dell'intero nella lista
     * @return il valore all'indice in input
     */
    public Integer get(int i) {
        if (i > lista.length) return null;
        return lista[i];
    }

    public boolean contains(int value) {
        for (int i : lista)
            if (i == value)
                return true;

        return false;
    }

    public int indexOf(int value) {
        for (int i = 0; i < lista.length; i++)
            if (lista[i] == value)
                return i;

        return -1;
    }

    @Override
    public String toString() { return Arrays.toString(lista); }


}