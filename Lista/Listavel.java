package Lista;

public interface Listavel {
    //C = inserir
    //C = anexar
    //R = selecionar
    //R = selecionarTodos
    //U = atualizar
    //D = apagar
    //D = limpar
    //S = (sort)    

    void inserir (Object dado, int posicao);
    void anexar (Object dado);
    Object selecionar (int posicao);
    Object[] selecoinarTodos ();
    void atualizar (Object dado, int posicao);
    Object apagar (int posicao);
    void limpar ();
    // boolean contem (Object dado);
    // int primeiraOcorrencia(Object dado);

    boolean estaCheia(); 
    boolean estaVazia();
    String imprimir();
}
