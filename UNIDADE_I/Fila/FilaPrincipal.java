package Fila;

public class FilaPrincipal {
    public static void main(String[] args) {
        Enfileiravel fila = new FilaEstaticaCircular(5);

        fila.enfileirar(1);
        fila.enfileirar(2);
        System.out.println(fila.frente());
        fila.desenfileirar();
        fila.enfileirar(3);
        fila.desenfileirar();
        fila.enfileirar(4);
        fila.enfileirar(5);
        fila.enfileirar(6);
        fila.enfileirar(7);
        System.out.println(fila.frente());
        fila.desenfileirar();
        System.out.println(fila.frente());
        fila.enfileirar(8);
        System.out.println("Fila: " + fila.imprimir());
    }
    
}
