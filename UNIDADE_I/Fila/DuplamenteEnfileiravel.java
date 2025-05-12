package Fila;

public interface DuplamenteEnfileiravel {
    void enfileirarInicio(Object dado); //implementar
    void enfileirarFim(Object dado);
    Object frente();//implementar
    Object tras(); 
    void atualizarInicio(Object dado);
    void atualizarFim(Object dado);
    Object desenfileirarInicio(); //implementar
    Object desenfileirarFim();

    boolean estaCheia();
    boolean estaVazia();
    String imprimirTrasFrente();
    String imprimirFrenteTras(); //implementar

}
