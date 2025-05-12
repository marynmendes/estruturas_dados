package PilhaFila;

public class PilhaComFilas implements Empilhavel{
    Enfileiravel f1;
    Enfileiravel f2;

    public PilhaComFilas(){
        this(10);
    }

    public PilhaComFilas(int tamanho){
        f1 = new FilaEstaticaCircular(tamanho);
        f2 = new FilaEstaticaCircular(tamanho);
    }

    //métodos auxiliares
    @Override
	public Boolean estaCheia() {
		return f1.estaCheia();
	}
		
	@Override
	public Boolean estaVazia() {
		return f1.estaVazia();
	}
		
	@Override
	public String imprimir() {
		return f1.imprimir();
	}

    //métodos principais
    @Override
    public void empilhar(Object dado){ //push
        if (!estaCheia()) {	
			while(!f1.estaVazia()) {
				f2.enfileirar(f1.desenfileirar());
			}
			f1.enfileirar(dado);
			while(!f2.estaVazia()) {
				f1.enfileirar(f2.desenfileirar());
			}
		} else {
			System.err.println("Stack is full!");
		}
    } 
    
    @Override
    public Object desempilhar(){ //pop
        Object dadoInicio = null;
		if (!estaVazia()) {
			dadoInicio = f1.desenfileirar();	
		} else {
			System.err.println("Stack is empty!");
		}
		return dadoInicio;
    } 
    
    @Override
    public Object espiar(){ //peek
        Object dadoInicio = null;
		if (!estaVazia()) {		
			return f1.frente();	
		} else {
			System.err.println("Pilha Vazia!");
		}
		return dadoInicio;
    } 

    @Override
	public void atualizar(Object dado) {
		if (!estaVazia()) {	
			f1.atualizarInicio(dado);
		} else {
			System.err.println("Pilha Vazia!");
		}			
	}
}
