package Lista;

public interface ListavelD<T> {
    //C = inserir
    //C = anexar
    //R = selecionar
    //R = selecionarTodos
    //U = atualizar
    //D = apagar
    //D = limpar
    //S = (sort)    

    void inserir (T dado, int posicao);
    void anexar (T dado);
    T selecionar (int posicao);
    T[] selecionarTodos ();
    void atualizar (T dado, int posicao);
    T apagar (int posicao);

    boolean estaCheia(); 
    boolean estaVazia();
    String imprimir();
}
