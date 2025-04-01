package Lista;

public class ListaEstaticaCircular implements Listavel {
    //variáveis de intância
    private Object[] dados;
    private int ponteiroInicio;
    private int ponteiroFim;
    private int quantidade;
    
    //construtores
    public ListaEstaticaCircular() {
        this(10);
    }

    public ListaEstaticaCircular(int tamanho) {
        dados = new Object[tamanho];
        ponteiroInicio = 0;
        ponteiroFim = -1;
        quantidade = 0;
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

    //métodos principais
    @Override
    public void anexar (Object dado){
         if(!estaCheia()){
            ponteiroFim = (ponteiroFim + 1)%dados.length;
            dados[ponteiroFim] = dado;
            quantidade++;
        } else {
            System.err.println("List is full!");
        }
    }

    int mapeamento (int logica){
        return (logica + ponteiroInicio)%dados.length;
    }

    @Override
    public void atualizar(Object dado, int posicao){
        if(!estaVazia()){
            if(posicao >= 0 && posicao < quantidade){
                int posicaoFisica = mapeamento(posicao);
                dados[posicaoFisica] = dado;
            } else {
                System.err.println("Invalid index!");
            }
        } else {
            System.err.println("List is empty!");
        }

    }
    
}
