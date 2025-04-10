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
    
    @Override
    public Object selecionar (int posicao){
        Object aux = null;
        if(!estaVazia()){
            if(posicao >= 0 && posicao < quantidade){
                int posicaoFisica = mapeamento(posicao);
                aux = dados[posicaoFisica];
            } else {
                System.err.println("Invalid index!");
            }
        } else {
            System.err.println("List is empty!");
        }
        return aux;
    }

    @Override
    public Object[] selecionarTodos(){
        Object[] aux = new Object[quantidade];
        if(!estaVazia()){    
            for(int i = 0; i < quantidade; i++){
                aux[i] = dados[(i+ponteiroInicio)%dados.length];
            }
        } else {
            System.err.println("List is empty!");
        }
        return aux;
    }

    @Override
    public void limpar(){
        quantidade = 0;
        ponteiroInicio = 0;
        ponteiroFim = -1;
    }

    // FAZER EM CASA
    private static boolean isIgual(Object dado, Object dado2){
        String conversao = dado.toString();
        String conversao2 = dado2.toString();
        return conversao.equals(conversao2);
    }

    @Override
    public int primeiraOcorrencia(Object dado){
        //caso não haja ocorrência, o método retornará -1 (índice inválido em uma lista)
        int indicador = -1;
        if(!estaVazia() && contem(dado)){
            int i=0;
            while(indicador < 0){
                if(ListaEstaticaCircular.isIgual(dado, dados[i])){
                    indicador = i;
                }
                i++;
            }
        }

        return indicador;
    }

    @Override
    public boolean contem(Object dado){
        boolean aux = false;
        for (int i = 0; i < quantidade; i++) {
           if(ListaEstaticaCircular.isIgual(dado, dados[i])){
                aux = true;
           }
        }

        return aux;
    }

    private int avancar (int ponteiro){
        return (ponteiro+1)%dados.length;
    }

    private int retroceder (int ponteiro){
        return (ponteiro-1+dados.length)%dados.length;
    }

    @Override
    public Object apagar(int posicao){
        Object aux = null;
        if(!estaVazia()){
            int posicaoFisica = mapeamento(posicao);
            aux = dados[posicaoFisica];
            int x = posicaoFisica;
            int y = avancar(x);
            for(int i = 0; i < quantidade-posicao - 1; i++){
                dados[x] = dados[y];
                x = avancar(x);
                y = avancar(y);
            }
            quantidade--;
            ponteiroFim = retroceder(ponteiroFim);
        }
        return aux;
    }

    @Override 
    public void inserir (Object dado, int posicao){
        if(!estaCheia()){
            if(posicao >= 0 && posicao <= quantidade){
                //int posicaoFisica = mapeamento(posicao);
                int x = ponteiroFim;
                int y = avancar(x);
                for(int i = 0; i < quantidade-posicao - 1; i++){
                    x = retroceder(x);
                    y = retroceder(y);
                }
                dados[x]=dado;
                quantidade++;
                ponteiroFim = avancar(ponteiroFim);
            }
        }      
    }
}
