public class PilhaInvertida implements Empilhavel {
     //variáveis de instância
    private Object[] dados;
    private int ponteiroTopo;
    
    //métodos
    //contrutores
    public PilhaInvertida(){
        this(10); //chama o construtor de baixo
    }
    public PilhaInvertida(int tamanho){
        dados = new Object[tamanho];
        ponteiroTopo = tamanho;
    }

    //métodos principais
    @Override
    public void empilhar(Object dado){ //push
        if(!estaCheia()){
            ponteiroTopo--;
            dados[ponteiroTopo] = dado;
        } else System.err.println("Stack is full!"); //exceção
    } 
    
    @Override
    public Object desempilhar(){ //pop
         Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroTopo];
            ponteiroTopo++;
        } else {
            System.out.println("Stack is empty!"); //exceção
        }
        return aux;
    } 
    
    @Override
    public Object espiar(){ //peek
        Object aux = null;
        if(!estaVazia()) {
			aux = dados[ponteiroTopo]; 
		} else {
			System.err.println("Pilha Vazia!");
		}
		return aux;
    } 
    
    @Override
    public void atualizar(Object dado){ //update
        if(!estaVazia()){
            dados[ponteiroTopo] = dado;
        } else {
            System.err.println("Stack is empty!"); //exceção
        }
    } 

    //métodos auxiliares
    @Override
    public Boolean estaCheia(){ //isFull
        return (ponteiroTopo == 0);
    }

    @Override
    public Boolean estaVazia(){ //isEmpty
        return (ponteiroTopo == dados.length);
    } 

    @Override
    public String imprimir(){ //print
        String aux = "[";
        for (int i = 0; i <= dados.length - 1; i++){
           	if (i == dados.length-1) {
				aux += dados[i];
			}
			else {
			    aux += dados[i] +  ",";
			}
		}
		return aux + "]";
    } 
}
