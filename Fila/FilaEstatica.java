package Fila;

public class FilaEstatica implements Enfileiravel {
    //variáveis de intância
    private Object[] dados;
    private int ponteiroInicio;
    private int ponteiroFim;
    
    //construtores
    public FilaEstatica() {
        this(10);
    }

    public FilaEstatica(int tamanho) {
        dados = new Object[tamanho];
        ponteiroInicio = 0;
        ponteiroFim = -1;
    }

    //métodos auxiliares
    @Override
    public boolean estaCheia(){
        return (ponteiroFim == dados.length - 1);
    }    

    @Override
    public boolean estaVazia(){
        return (ponteiroFim == ponteiroInicio - 1);
    }

    @Override
    public String imprimir(){
        String retorno = "[";
        for (int i = ponteiroInicio; i <= ponteiroFim; i++){
            if (i == ponteiroFim){
                retorno += dados[i];
            } else {
                retorno += dados[i] + ",";
            }
        }

        return retorno + "]";
    }

    @Override
    public void enfileirar(Object dado){
        if(!estaCheia()){
            ponteiroFim++;
            dado = dados[ponteiroFim];
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
            ponteiroInicio++;
        } else {
            System.err.println("Queue is empty!");
        }

        return aux;
    }

}
