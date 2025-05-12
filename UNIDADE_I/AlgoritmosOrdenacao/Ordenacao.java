package AlgoritmosOrdenacao;

public class Ordenacao {
    int[] lista = {1, 6, 8, 3, 8, 2, 9, 5, 0};

    public void bubbleSort (){
        for(int i = 0; i<lista.length-1; i++){
            for(int j = 0; j<(lista.length-i-1); j++){
                if(lista[j]>lista[j+1]){
                    troca(j, j+1);
                }
            }
        }
    }

    public void troca(int indice, int indice2){
        int aux = lista[indice2];
        lista[indice2] = lista[indice];
        lista[indice] = aux;
    }

    public void imprimir() {
        for(int dado:lista){
            System.out.print(dado + " ");
        }
        System.out.println(" ");
    }

    public void selectionSort(){
        for(int j = 0; j<lista.length; j++){
            int menor = j;
            for(int i = 1+j; i<lista.length; i++){
                if(lista[menor]>lista[i]){
                    menor = i;
                }
            }
            troca(j, menor);
        }   
    }
    
    public void insertionSort(){
        for(int j = 1; j<lista.length; j++){
            for(int i = j-1; i>=0; i--){
                if(lista[i]>lista[i+1]){
                    troca(i, i+1);
                } else break;
            }
        }
    }
    
    public static void main(String[] args) {
        Ordenacao sort = new Ordenacao();
        sort.imprimir();
        sort.insertionSort();
        sort.imprimir();

    }
}
