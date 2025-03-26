package Fila;

public interface DuplamenteEnfileiravel {
    void enfileirarInicio(Object dado);
    void enfileirarFim(Object dado); //implementar
    Object frente();
    Object tras(); //implementar
    void atualizarInicio(Object dado);
    void atualizarFim(Object dado);
    Object desenfileirarInicio();
    Object desenfileirarFim(); //implementar

    boolean estaCheia();
    boolean estaVazia();
    String imprimirTrasFrente();
    String imprimirFrenteTras(); //implementar

}
