package Prova2024;

public class Lista {
    private Object[] dados;
    private int quantidade = 0;
    private int ponteiroInicio = 0;
    private int ponteiroFim = -1;

    public Lista(int tamanho){
        dados = new Object[tamanho];
    }
    
    public boolean estaCheia(){ 
        return quantidade == dados.length;
    }
    
    public boolean estaVazia(){ 
        return quantidade == 0;
    }

    private int avancar (int ponteiro){
        return (ponteiro+1)%dados.length;
    }

    int mapeamento (int logica){
        return (logica + ponteiroInicio)%dados.length;
    }

    private int retroceder (int ponteiro){
        return (ponteiro-1+dados.length)%dados.length;
    }

    public Object apagar(int posicao){
        Object aux = null;
        if(!estaVazia() && (posicao >= 0 && posicao < quantidade)){
            int posicaoFis = mapeamento(posicao);
            aux = dados[posicaoFis];
            int x = posicaoFis;
            int y = retroceder(x);
            for(int i = 0; i<quantidade-posicao+1; i++){
                dados[x] = dados[y];
                x = retroceder(x);
                y = retroceder(y);
            }
            quantidade--;
            ponteiroInicio = avancar(ponteiroInicio);
        }
        return aux;
    }
}
