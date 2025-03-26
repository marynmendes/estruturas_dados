package Fila;

public class FilaPrincipal {
    public static void main(String[] args) {
        Enfileiravel fila = new FilaEstaticaCircular(5);

        fila.enfileirar("mary");
        fila.enfileirar("nicole");
        System.out.println(fila.frente());
        fila.desenfileirar();
        fila.enfileirar("de");
        fila.desenfileirar();
        fila.enfileirar("sousa");
        System.out.println("Fila: " + fila.imprimir());
    }
    
}
