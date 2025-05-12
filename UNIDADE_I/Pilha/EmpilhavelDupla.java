public interface EmpilhavelDupla {
    //operações pilha 1 (de baixo para cima)
    void empilhar1(Object dado); //push
    Object desempilhar1(); //pop
    Object espiar1(); //peek
    void atualizar1(Object dado); //update
    Boolean estaCheia1(); //isFull
    Boolean estaVazia1(); //isEmpty
    String imprimir1(); //print

    //operações pilha 2 (de cima para baixo)
    void empilhar2(Object dado); //push
    Object desempilhar2(); //pop
    Object espiar2(); //peek
    void atualizar2(Object dado); //update
    Boolean estaCheia2(); //isFull
    Boolean estaVazia2(); //isEmpty
    String imprimir2(); //print
}