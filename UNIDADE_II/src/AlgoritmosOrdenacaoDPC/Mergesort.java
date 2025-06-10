package AlgoritmosOrdenacaoDPC;
/**
 * Classe para o algoritmo de ordenação mergesort
 * Possui o método "merge"
 * Complexidade n log de n
 * 
 * @author Mendes M. N. S
 * @version 1.1
 * @since 10-06-2025
 */
public class Mergesort {

    /**
     * Método que une ordenadamente dois arrays
     * 
     * @param a array ordenado
     * @param b array ordenado
     * @return array com os valores de a e b ordenados
     */
    public static int[] merge(int[] a, int[] b) {
        //a = [1, 3, 6, 8]     b = [2, 3, 5]
        int[] resultado = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                resultado[k++] = a[i++];
            } else {
                resultado[k++] = b[j++];
            }
        }

        while (i < a.length) {
            resultado[k++] = a[i++];
        }

        while (j < b.length) {
            resultado[k++] = b[j++];
        }

        return resultado;
    }

    public static String imprimir(int[] a){
        String resultado = "";
        for (Integer valor: a) {
            resultado += valor + "  ";
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 8};
        int[] b = {2, 3, 5};
        System.out.println(imprimir(merge(a, b)));
    }
}
