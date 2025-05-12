public class PilhaEstatica implements Empilhavel {
    //variáveis de instância
    private Object[] dados;
    private int ponteiroTopo;
    
    //métodos
    //contrutores
    public PilhaEstatica(){
        this(10); //chama o construtor de baixo
    }
    public PilhaEstatica(int tamanho){
        dados = new Object[tamanho];
        ponteiroTopo = -1;
    }

    //métodos principais
    @Override
    public void empilhar(Object dado){ //push
        if(!estaCheia()){
            ponteiroTopo++;
            dados[ponteiroTopo] = dado;
        } else System.err.println("Stack is full!"); //exceção
    } 
    
    @Override
    public Object desempilhar(){ //pop
         Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroTopo];
            dados[ponteiroTopo] = null;
            ponteiroTopo--;
        } else {
            System.out.println("Stack is empty!"); //exceção
        }
        return aux;
    } 
    
    @Override
    public Object espiar(){ //peek
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroTopo];
        } else {
            System.err.println("Stack is empty!"); //exceção
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
        return (ponteiroTopo == dados.length -1);
    }

    @Override
    public Boolean estaVazia(){ //isEmpty
        return (ponteiroTopo == -1);
        /*if (ponteiroTopo == -1){
            return true;
        }
        */
    } 

    @Override
    public String imprimir(){ //print
        String aux = "[";
        for (int i = ponteiroTopo; i >= 0; i--){
            if(i == 0){
                aux += dados[i];
            } else aux += dados[i] + ",";
        }
        return aux + "]";
    } 
}