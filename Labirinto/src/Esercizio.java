import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Esercizio {
    public static void main(String[] args) {
        char[][] labirinth = generateLab();
        startGame(labirinth);
    }

    private static void startGame(char[][] lab) {
        Scanner sc = new Scanner(System.in);

        int endRow = -1;
        int endCol = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (lab[i][j] == 'E') {
                    endRow = i;
                    endCol = j;
                    break;
                }
            }
            if (endRow != -1) {
                break;
            }
        }

        int currentRow = -1;
        int currentCol = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (lab[i][j] == 'P') {
                    currentRow = i;
                    currentCol = j;
                    break;
                }
            }
            if (currentRow != -1) {
                break;
            }
        }

        while((endRow != currentRow) || (endCol != currentCol)) {
            System.out.println("Fai la tua mossa!");
            String mossa = sc.next();
            switch (mossa) {
                case "w":
                    if (currentRow == 0 || lab[currentRow - 1][currentCol] == 'W') {
                        System.out.println("NON PUOI SALIRE!");
                    } else {
                        lab[currentRow][currentCol] = '-';
                        currentRow--;
                    }
                    break;
                case "a":
                    if (currentCol == 0 || lab[currentRow][currentCol - 1] == 'W') {
                        System.out.println("NON ANDARE A SINISTRA!");
                    } else {
                        lab[currentRow][currentCol] = '-';
                        currentCol--;
                    }
                    break;
                case "s":
                    if (currentRow == lab.length - 1 || lab[currentRow + 1][currentCol] == 'W') {
                        System.out.println("NON PUOI SCENDERE!");
                    } else {
                        lab[currentRow][currentCol] = '-';
                        currentRow++;
                    }
                    break;
                case "d":
                    if (currentCol == lab.length - 1 || lab[currentRow][currentCol + 1] == 'W') {
                        System.out.println("NON PUOI ANDARE A DESTRA!");
                    } else {
                        lab[currentRow][currentCol] = '-';
                        currentCol++;
                    }
                    break;
            }
            lab[currentRow][currentCol] = 'P';
            printLab(lab);
        }
        System.out.println("HAI VINTO!!");
    }


    private static char[][] generateLab() {
        // Labirinto pre impostato
        // char[][] mat = {{'-','-', 'W', 'W', '-'},{'-','W', '-', 'W', '-'},{'P','W', '-', 'W', 'W'},{'-','-', 'W', '-', 'E'},{'W','-', '-', '-', 'W'}};

        char[][] mat = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mat[i][j] = 'W';
            }
        }
        Random random = new Random();

        //Genero in maniera randomica la posizione di P e di E
        boolean start = random.nextBoolean();
        int randomStart = random.nextInt(mat.length);
        int randomEnd = random.nextInt(mat.length);
        String mosse;
        int endRow, endCol, currentRow, currentCol, startCol, startRow;
        //Genero un  punto di partenza e di uscita causali e opposti
        if(start){
            mat[0][randomStart] = 'P';
            mat[mat.length-1][randomEnd] = 'E';
            endRow = mat.length-1;
            endCol = randomEnd;
            currentCol = randomStart;
            currentRow = 0;
            startCol = randomStart;
            startRow = 0;
            mosse = "sad";
        } else{
            mat[randomStart][0] = 'P';
            mat[randomEnd][mat.length-1] = 'E';
            mosse = "wsd";
            endRow = randomEnd;
            endCol = mat.length-1;
            currentCol = 0;
            currentRow = randomStart;
            startCol = 0;
            startRow = randomStart;
        }

        int count = 0;
        while(endRow != currentRow || endCol != currentCol){
            //SCELGO LA MOSSA DA SELEZIONARE
            if(start){
                if(currentRow == 4){
                    if(currentCol > endCol){
                        mosse = "a";
                    } else {
                        mosse = "d";
                    }
                }
            } else {
                if(currentCol == 4){
                    if(currentRow > endRow){
                        mosse = "w";
                    } else {
                        mosse = "s";
                    }
                }
            }
            char mos = mosse.charAt(random.nextInt(mosse.length()));

            switch (mos) {
                case 'w':
                    if (currentRow != 0 && (mat[currentRow-1][currentCol] == 'W' || mat[currentRow-1][currentCol] == 'E')) {
                        mat[currentRow-1][currentCol] = '-';
                        currentRow--;
                        count++;
                    }
                    break;
                case 'a':
                    if (currentCol != 0 && (mat[currentRow][currentCol-1] == 'W' || mat[currentRow][currentCol-1] == 'E')) {
                        mat[currentRow][currentCol-1] = '-';
                        currentCol--;
                        count++;
                    }
                    break;
                case 'd':
                    if (currentCol != 4 && (mat[currentRow][currentCol+1] == 'W' || mat[currentRow][currentCol+1] == 'E')) {
                        mat[currentRow][currentCol+1] = '-';
                        currentCol++;
                        count++;
                    }
                    break;
                case 's':
                    if (currentRow != 4 && (mat[currentRow+1][currentCol] == 'W' || mat[currentRow+1][currentCol] == 'E')){
                        mat[currentRow+1][currentCol] = '-';
                        currentRow++;
                        count++;
                    }
                    break;
            }

        }

        if(count < 12){
            for(int i = count; i < 12; i++){
                int x = random.nextInt(5);
                int y = random.nextInt(5);
                if(mat[x][y] == 'W'){
                    mat[x][y] = '-';
                } else {
                    i--;
                }
            }
        }
        mat[startRow][startCol] = 'P';
        mat[endRow][endCol] = 'E';
        printLab(mat);
        System.out.println("Iniziamo!");
        return mat;
    }

    private static void printLab(char[][] lab){
        for(int i=0; i< lab.length;i++){
            for(int j=0; j< lab.length; j++){
                System.out.print( lab[i][j]);
            }

            System.out.println();
        }
    }
}
