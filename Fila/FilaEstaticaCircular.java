package Fila;

public class FilaEstaticaCircular implements Enfileiravel{
    //variáveis de intância
    private Object[] dados;
    private int ponteiroInicio;
    private int ponteiroFim;
    int quantidade;
    
    //construtores
    public FilaEstaticaCircular() {
        this(10);
    }

    public FilaEstaticaCircular(int tamanho) {
        dados = new Object[tamanho];
        ponteiroInicio = 0;
        ponteiroFim = -1;
    }

    //métodos auxiliares
    @Override
    public boolean estaCheia(){
        return (quantidade == dados.length);
    }    

    @Override
    public boolean estaVazia(){
        return (quantidade == 0);
    }

    @Override
    public String imprimir(){
        String retorno = "[";
        for (int i = ponteiroInicio; i < quantidade + ponteiroInicio; i++){
            if (i == quantidade + ponteiroInicio - 1){
                retorno += dados[i % dados.length];
            } else {
                retorno += dados[i % dados.length] + ",";
            }
        }

        return retorno + "]";
    }

    @Override
    public void enfileirar(Object dado){
        if(!estaCheia()){
            ponteiroFim = (ponteiroFim + 1)%dados.length;
            dado = dados[ponteiroFim];
            quantidade++;
        } else {
            System.err.println("Queue is full!");
        }
    }

    @Override
    public Object frente(){
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroInicio];
        } else {
            System.err.println("Queue is empty!");
        }

        return aux;
    }


    @Override
    public void atualizarInicio(Object dado){
        if(!estaVazia()){
            dados[ponteiroInicio] = dado;
        } else {
            System.err.println("Queue is empty!");
        }
    }

    @Override
    public void atualizarFim(Object dado){
        if(!estaVazia()){
            dados[ponteiroInicio] = dado;
        } else {
            System.err.println("Queue is empty!");
        }
    }


    @Override
    public Object desenfileirar(){
        Object aux = null;
        if(!estaVazia()){
            aux = dados[ponteiroInicio];
            ponteiroInicio = (ponteiroInicio + 1)%dados.length;
            quantidade--;
        } else {
            System.err.println("Queue is empty!");
        }

        return aux;
    }
}
