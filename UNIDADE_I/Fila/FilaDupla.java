package Fila;

public class FilaDupla implements DuplamenteEnfileiravel{
     //variáveis de intância
    private Object[] dados;
    private int ponteiroInicio;
    private int ponteiroFim;
    private int quantidade;

    //construtores
    public FilaDupla() {
        this(10);
    }

    public FilaDupla(int tamanho) {
        dados = new Object[tamanho];
        ponteiroInicio = 0;
        ponteiroFim = -1;
    }

     @Override
    public boolean estaCheia() {
        return quantidade == dados.length;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public void enfileirarFim(Object dado) {
        if (!estaCheia()) {
            ponteiroFim = avancar(ponteiroFim);
            dados[ponteiroFim] = dado;
            if (quantidade == 0) {
                ponteiroInicio = ponteiroFim;
            }
            quantidade++;
        } else {
            System.err.println("Queue is full");
        }
    }

    @Override
    public void enfileirarInicio(Object dado) {
        if (!estaCheia()) {
            ponteiroInicio = retroceder(ponteiroInicio);
            dados[ponteiroInicio] = dado;
            if (quantidade == 0) {
                ponteiroFim = ponteiroInicio;
            }
            quantidade++;
        } else {
            System.err.println("Queue is full");
        }
    }

    @Override
    public Object frente() {
        return !estaVazia() ? dados[ponteiroInicio] : erroFilaVazia();
    }

    @Override
    public Object tras() {
        return !estaVazia() ? dados[ponteiroFim] : erroFilaVazia();
    }

    @Override
    public void atualizarInicio(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroInicio] = dado;
        } else {
            System.err.println("Queue is empty!");
        }
    }

    @Override
    public void atualizarFim(Object dado) {
        if (!estaVazia()) {
            dados[ponteiroFim] = dado;
        } else {
            System.err.println("Queue is empty!");
        }
    }

    @Override
    public Object desenfileirarInicio() {
        if (!estaVazia()) {
            Object aux = dados[ponteiroInicio];
            ponteiroInicio = avancar(ponteiroInicio);
            quantidade--;
            return aux;
        } else {
            return erroFilaVazia();
        }
    }

    @Override
    public Object desenfileirarFim() {
        if (!estaVazia()) {
            Object aux = dados[ponteiroFim];
            ponteiroFim = retroceder(ponteiroFim);
            quantidade--;
            return aux;
        } else {
            return erroFilaVazia();
        }
    }

    @Override
    public String imprimirFrenteTras() {
        String retorno = "[";
        int ponteiroAux = ponteiroInicio;
        for (int i = 0; i < quantidade; i++) {
            retorno += (dados[ponteiroAux]);
            if (i < quantidade - 1) {
                retorno += (",");
            }
            ponteiroAux = avancar(ponteiroAux);
            
        }
        retorno += "]";
        return retorno;
    }

    @Override
    public String imprimirTrasFrente() {
        String retorno = "[";
        int ponteiroAux = ponteiroFim;
        for (int i = 0; i < quantidade; i++) {
            retorno += (dados[ponteiroAux]);
            if (i < quantidade - 1) {
                retorno += (",");
            }
            ponteiroAux = retroceder(ponteiroAux);
        }
        retorno += ("]");
        return retorno;
    }

    private int avancar(int ponteiro) {
        return (ponteiro + 1) % dados.length;
    }

    private int retroceder(int ponteiro) {
        return (ponteiro - 1 + dados.length) % dados.length;
    }

    private Object erroFilaVazia() {
        System.err.println("Queue is empty");
        return null;
    }

}
