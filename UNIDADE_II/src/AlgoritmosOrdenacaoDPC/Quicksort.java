package AlgoritmosOrdenacaoDPC;

import java.util.Arrays;

/**
 * Classe para o algotimo de ordenação Quicksort, que, 
 * no melhor caso, possui complexidade n log de n
 * 
 * @author Mendes M. N. S.
 * @version 1.1
 * @since 10-06-2025
 */
public class Quicksort {
    
    public static void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particionar(array, inicio, fim);

            quickSort(array, inicio, posicaoPivo - 1); 
            quickSort(array, posicaoPivo + 1, fim);    
        }
    }

    private static int particionar(int[] array, int inicio, int fim) {
        int pivo = array[fim];
        int i = inicio - 1;    

        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivo) {
                i++;
                trocar(array, i, j);
            }
        }

        trocar(array, i + 1, fim);
        return i + 1;
    }

    private static void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] array = { 10, 7, 8, 9, 1, 5 };

        System.out.println("Array original:");
        System.out.println(Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(array));
    }
}
