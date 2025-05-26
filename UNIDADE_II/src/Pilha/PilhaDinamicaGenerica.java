package Pilha;
import java.util.NoSuchElementException;

/**
 * Essa classe implementa uma Pilha Dinâmica Genérica,
 * estrutura de dados do tipo LIFO (Last In First Out).
 * 
 * @author Mendes, M. N. S.
 * @version 1.1
 * @since 2025-05-05
 */

public class PilhaDinamicaGenerica<T> implements EmpilhavelD<T>{
    private NodoDuplo<T> ponteiroTopo;
    private int quantidade;
    private int tamanho;

    /**
     * Construtor vazio.
     */
    public PilhaDinamicaGenerica(){
        this(10);
    }

    /**
     * Construtor que recebe um tamanho máximo.
     * 
     * @param tamanho refere-se ao tamanho 
     * máximo que a estrutura pode ter.
     */
    public PilhaDinamicaGenerica(int tamanho){
        quantidade = 0;
        this.tamanho = tamanho;
    }

    /**
     * Verifica se a Pilha está vazia.
     * 
     * @return true, se estiver vazia, false caso contrário.
     */
    @Override
    public Boolean estaVazia(){
        return quantidade==0;
    }

    /**
     * Verifica se a Pilha está cheia.
     * 
     * @return true, se estiver cheia, false caso contrário.
     */
    @Override
    public Boolean estaCheia(){
        return quantidade==tamanho;
    }

    /**
     * Gera uam infromação textual dos elementos da Pilha.
     * 
     * @return uma String contendo as informações de cada
     * elemento, separadas por vírgula e  delimitadas por colchetes.
     */
   @Override
	public String imprimir() {
		NodoDuplo<T> ponteiroAuxiliar = ponteiroTopo;
		String resultado = "[";
		for (int i = quantidade - 1; i >= 0; i--) {
			resultado += ponteiroAuxiliar.getDado();
			if (i != 0) {
				resultado += ",";
			}
			ponteiroAuxiliar = ponteiroAuxiliar.getAnterior();
		}
		return resultado + "]";
	}

    /**
     * Mostra o elemento no topo da Pilha.
     * 
     * @return elemento no topo da Pilha.
     * @throws NoSuchElementException caso a Pilha
     * esteja vazia.
     */
    @Override
    public T espiar(){
        if(estaVazia()){
            throw new NoSuchElementException("Pilha vazia!");
        }
        return ponteiroTopo.getDado();
    }

    /**
     * Atualiza o topo da Pilha com um novo dado.
     * 
     * @param novoDado é o dado que será posto no topo da lista,
     * substituindo o que já está lá.
     * @throws NoSuchElementException caso a Pilha
     * esteja vazia.
     */
    @Override
    public void atualizar(T novoDado){
        if(estaVazia()){
            throw new NoSuchElementException("Pilha vazia!");
        } 
        ponteiroTopo.setDado(novoDado);
    }

    /**
     * Retira o elemento do topo da Pilha.
     * 
     * @return elemento retirado da pilha.
     * @throws NoSuchElementException caso a Pilha
     * esteja vazia.
     */
    @Override
    public T desempilhar() {
		if (estaVazia()) {
			throw new NoSuchElementException("Pilha vazia!");
		}
		T dadoTopo = ponteiroTopo.getDado();
		ponteiroTopo = ponteiroTopo.getAnterior();
		quantidade--;
		if (!estaVazia()) {
			ponteiroTopo.setProximo(null);
		}
		return dadoTopo;
	}


    /**
     * Adiciona um elemento ao topo da Pilha.
     * 
     * @param dado é o dado que será adicionado
     * @throws NoSuchElementException caso a Pilha esteja cheia
     */ 
    @Override
    public void empilhar(T dado){
        if(estaCheia()){
            throw new NoSuchElementException("Pilha cheia!");
        }
        NodoDuplo<T> novoNodo = new NodoDuplo<>();
        novoNodo.setDado(dado);
        novoNodo.setAnterior(ponteiroTopo);
        if (!estaVazia()) {
			ponteiroTopo.setProximo(novoNodo);
		}
		ponteiroTopo = novoNodo;
		quantidade++;	
    }
}