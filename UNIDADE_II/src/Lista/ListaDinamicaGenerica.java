package Lista;
import Excecao.OverflowException;
import Excecao.UnderflowException;

public class ListaDinamicaGenerica<T> implements ListavelD<T>{
    private NodoDuplo<T> ponteiroInicio;
    private NodoDuplo<T> ponteiroFim;
    private int quantidade;
    private int tamanho;
    
    public ListaDinamicaGenerica(int tamanho) {
        this.tamanho = tamanho;
        this.ponteiroFim = null;
        this.ponteiroInicio = null;
        this.quantidade = 0;
    }

    public ListaDinamicaGenerica(){
        this(10);
        
    }

    @Override
    public void inserir(T dado, int posicao) {
        if(estaCheia()){
            throw new OverflowException("Está cheia!");
        }
        if(!(posicao >=0 && posicao <= quantidade)){
            throw new IndexOutOfBoundsException("Indice Invalido!");
        }
        NodoDuplo<T> noTemporario = new NodoDuplo<>();
		noTemporario.setDado(dado);

		NodoDuplo<T> ponteiroAnterior = null;
		NodoDuplo<T> ponteiroProximo = ponteiroInicio;

		for (int i = 0; i < posicao; i++) {
			ponteiroAnterior = ponteiroProximo;
			ponteiroProximo = ponteiroProximo.getProximo();
		}

		if (ponteiroAnterior != null) {
			ponteiroAnterior.setProximo(noTemporario);
			// se o anterior é nulo é pq a insercao está sendo no inicio
		} else {
			ponteiroInicio = noTemporario;
		}

		if (ponteiroProximo != null) {
			ponteiroProximo.setAnterior(noTemporario);
			// se o proximo é nulo é pq a insercao está sendo no fim (append)
		} else {
			ponteiroFim = noTemporario;
		}

		noTemporario.setAnterior(ponteiroAnterior);
		noTemporario.setProximo(ponteiroProximo);

		quantidade++;
    }

    @Override
    public void anexar(T dado) {
		if (estaCheia()) {
			throw new OverflowException("Lista Cheia!");
		}
		NodoDuplo<T> noTemporario = new NodoDuplo<>();
		noTemporario.setDado(dado);
		if (!estaVazia()) {
			ponteiroFim.setProximo(noTemporario);
		} else {
			ponteiroInicio = noTemporario;
		}
		noTemporario.setAnterior(ponteiroFim);
		ponteiroFim = noTemporario;
		quantidade++;
	}

    @Override
    public T selecionar(int posicao) {
        if(estaVazia()){
            throw new UnderflowException("Está vazia!");
        }
        if (!(posicao >= 0 && posicao <= quantidade)){
            throw new IndexOutOfBoundsException("Indice Invalido!");
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for(int i = 0; i < posicao; i++){
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        return ponteiroAuxiliar.getDado();
    }

    @Override
    public T[] selecionarTodos() {
        if(estaVazia()){
            throw new UnderflowException("Está vazia!");
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
		T[] array = (T[])new Object[quantidade];
		for (int i = 0; i < quantidade; i++) {
			array[i] = ponteiroAuxiliar.getDado();
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
		}
		return array;
    }

    @Override
    public void atualizar(T dado, int posicao) {
        if(estaVazia()){
            throw new UnderflowException("Está vazia.");
        }
        if (posicao < 0 || posicao >= quantidade){
            throw new IndexOutOfBoundsException("Índice inválido!");
        }
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
        for(int i = 0; i < posicao; i++){
            ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
        }
        ponteiroAuxiliar.setDado(dado);
    }

    @Override
    public T apagar(int posicao) {
        if (estaVazia()) {
			throw new UnderflowException("Está vazia!");
		}
		if (!(posicao >= 0 && posicao < quantidade)) {
			throw new IndexOutOfBoundsException("Indice Invalido!");
		}

		NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
		for (int i = 0; i < posicao; i++) {
			ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
		}

		NodoDuplo<T> ponteiroAnterior = ponteiroAuxiliar.getAnterior();
		NodoDuplo<T> ponteiroProximo = ponteiroAuxiliar.getProximo();

		if (ponteiroAnterior != null) {
			ponteiroAnterior.setProximo(ponteiroProximo);
			// remocao do inicio, joga o ponteiro de inicio para o proximo nodo.
		} else {
			ponteiroInicio = ponteiroInicio.getProximo();
		}
		if (ponteiroProximo != null) {
			ponteiroProximo.setAnterior(ponteiroAnterior);
			// remocao do fim, joga o ponteiro de fim para o nodo anterior.
		} else {
			ponteiroFim = ponteiroFim.getAnterior();
		}

		quantidade--;
		return ponteiroAuxiliar.getDado();
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
    public String imprimir() {
        NodoDuplo<T> ponteiroAuxiliar = ponteiroInicio;
		String resultado = "[";
		for (int i = 0; i < quantidade; i++) {
			resultado += ponteiroAuxiliar.getDado();
			if (i != (quantidade-1)) {
				resultado += ",";
			}
			ponteiroAuxiliar = ponteiroAuxiliar.getProximo();
		}
		return resultado + "]";
    }
    
    
}
