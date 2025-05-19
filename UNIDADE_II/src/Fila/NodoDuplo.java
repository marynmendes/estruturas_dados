package Fila;
/**
 * Esta classe representa um nó de uma lista duplamente encadeada.
 * 
 * @author Mendes, M. N. S.
 * @version 1.1
 * @since 2025-05-05
 */


 //javadoc -d doc src/*.java

public class NodoDuplo<T>{

    private NodoDuplo<T> anterior;
    private T dado;
    private NodoDuplo<T> proximo;

    public NodoDuplo() {
    }

    public NodoDuplo(T dado) {
        this.dado = dado;
    }

    public NodoDuplo<T> getAnterior() {
        return anterior;
    }
    public void setAnterior(NodoDuplo<T> anterior) {
        this.anterior = anterior;
    }
    public T getDado() {
        return dado;
    }
    public void setDado(T dado) {
        this.dado = dado;
    }
    public NodoDuplo<T> getProximo() {
        return proximo;
    }
    public void setProximo(NodoDuplo<T> proximo) {
        this.proximo = proximo;
    }
    
    

}