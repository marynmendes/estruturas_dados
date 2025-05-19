/**
 * Esta classe implementa uma Fila Dinâmica Genérica,
 * estrutura de dados do tipo FIFO (First In First Out).
 * 
 * @author Mendes, M. N. S
 * @version 1.1
 * @since 2025-05-12
 */

 //fazer toda a documentação na prova ;)
package Fila;

import java.util.NoSuchElementException;

public class FilaDinamicaGenerica<T> implements EnfileiravelD<T> {
    private NodoDuplo<T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;
    private int quantidade;
    private int tamanho;

    public FilaDinamicaGenerica() {
        this(10);
    }

    public FilaDinamicaGenerica(int tamanho) {
        ponteiroFim = null;
        ponteiroInicio = null;
        quantidade = 0;
        this.tamanho = tamanho;
    }

    @Override
    public void enfileirarInicio(T dado) {
        throw new UnsupportedOperationException("Operação não suportada.");
    }

    @Override
    public void enfileirarFim(T dado) {
        if(estaCheia()){
            throw new NoSuchElementException("Fila está cheia!");
        } else {
            NodoDuplo<T> novoNodo = new NodoDuplo<>(dado);
            novoNodo.setAnterior(ponteiroFim);
            if(!estaVazia()){
                ponteiroFim.setProximo(novoNodo);
            } else {
                ponteiroFim = novoNodo;
            quantidade++;
            }
            
        }
    }

    @Override
    public T frente() {
       if(estaVazia()){
        throw new NoSuchElementException("Fila está vazia.");
       } else return ponteiroInicio.getDado();
    }

    @Override
    public T tras() {
        throw new UnsupportedOperationException("Operação não suportada.");
    }

    @Override
    public void atualizarInicio(T dado) {
        if(estaVazia()){
            throw new NoSuchElementException("Fila está vazia.");
        } else {
            ponteiroInicio.setDado(dado);
        }
    }

    @Override
    public void atualizarFim(T dado) {
        if(estaVazia()){
            throw new NoSuchElementException("Fila está vazia.");
        } else ponteiroFim.setDado(dado);
        
    }

    @Override
    public T desenfileirarInicio() {
        T auxiliar = null;
        if(estaVazia()){
            throw new NoSuchElementException("Fila está vazia");
        } else {
            auxiliar = ponteiroInicio.getDado();
            ponteiroInicio = ponteiroInicio.getProximo();
            ponteiroInicio.setAnterior(null);
            quantidade--;

        }
        return auxiliar;
    }

    @Override
    public T desenfileirarFim() {
        throw new UnsupportedOperationException("Operação não suportada.");
    }

    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public String imprimirTrasFrente() {
        throw new UnsupportedOperationException("Operação não suportada.");
    }

    @Override
    public String imprimirFrenteTras() {
        NodoDuplo<T> aux = ponteiroInicio;
        String retorno = "[";
        for(int i = 0; i< quantidade; i++){
            retorno += aux.getDado();
            if(i != quantidade-1){
                retorno += ", ";
            }
            aux = aux.getProximo();
        }
        return retorno + "]";
    }

    
}
