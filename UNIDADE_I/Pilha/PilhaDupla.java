

public class PilhaDupla implements EmpilhavelDupla {
    //variáveis de instância
    private Object[] dados;
    private int ponteiroTopo1, ponteiroTopo2;

    //construtores
    public PilhaDupla() {
        this(10);
    }

    public PilhaDupla(int tamanho) {
        dados = new Object[tamanho];
        ponteiroTopo1 = -1;
        ponteiroTopo2 = tamanho;
    }


    //operações pilha 1 (de baixo para cima)
    @Override
    public void empilhar1(Object dado) { //push1
        if(!estaCheia1()){
            ponteiroTopo1++;
            dados[ponteiroTopo1] = dado; 
        } else System.err.println("Stack 1 is full!");
    }

    @Override
    public Object desempilhar1(){ //pop1
        Object aux = null;
        if(!estaVazia1()){
            aux = dados[ponteiroTopo1];
            dados[ponteiroTopo1] = null;
            ponteiroTopo1--;
        } else {
            System.out.println("Stack 1 is empty!"); //exceção
        }
        return aux;
    } 

    @Override
    public Object espiar1(){ //peek1
        Object aux = null;
        if(!estaVazia1()){
            aux = dados[ponteiroTopo1];
        } else {
            System.err.println("Stack 1 is empty!"); //exceção
        }
        return aux;
    }

    @Override
    public void atualizar1(Object dado){ //update1
        if(!estaVazia1()){
            dados[ponteiroTopo1] = dado;
        } else {
            System.err.println("Stack 1 is empty!"); //exceção
        }
    } 
     @Override
    public Boolean estaCheia1(){ //isFull1
        return (ponteiroTopo1 == ponteiroTopo2 - 1);
    }
    @Override
    public Boolean estaVazia1(){ //isEmpty1
        return (ponteiroTopo1 == -1);
    } 

    @Override
    public String imprimir1(){ //print1
        String aux = "[";
        for (int i = ponteiroTopo1; i >= 0; i--){
            if(i == 0){
                aux += dados[i];
            } else aux += dados[i] + ",";
        }
        return aux + "]";
    }

    //operações pilha 2 (de cima para baixo)
    @Override
    public void empilhar2(Object dado){ //push2
        if(!estaCheia2()){
            ponteiroTopo2--;
            dados[ponteiroTopo2] = dado;
        } else System.err.println("Stack is full!"); //exceção
    } 
    
    @Override
    public Object desempilhar2(){ //pop2
         Object aux = null;
        if(!estaVazia2()){
            aux = dados[ponteiroTopo2];
            ponteiroTopo2++;
        } else {
            System.out.println("Stack is empty!"); //exceção
        }
        return aux;
    } 
    
    @Override
    public Object espiar2(){ //peek2
        Object aux = null;
        if(!estaVazia2()) {
			aux = dados[ponteiroTopo2]; 
		} else {
			System.err.println("Pilha Vazia!");
		}
		return aux;
    } 
    
    @Override
    public void atualizar2(Object dado){ //update2
        if(!estaVazia2()){
            dados[ponteiroTopo2] = dado;
        } else {
            System.err.println("Stack is empty!"); //exceção
        }
    } 

    @Override
    public Boolean estaCheia2(){ //isFull2
        return (ponteiroTopo2 == ponteiroTopo1 + 1);
    }

    @Override
    public Boolean estaVazia2(){ //isEmpty2
        return (ponteiroTopo2 == dados.length);
    } 

    @Override
    public String imprimir2(){ //print2
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