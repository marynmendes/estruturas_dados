public interface Empilhavel {
    //operações principais
    void empilhar(Object dado); //push
    Object desempilhar(); //pop
    Object espiar(); //peek
    void atualizar(Object dado); //update
    
    //operações auxiliares
    Boolean estaCheia(); //isFull
    Boolean estaVazia(); //isEmpty
    String imprimir(); //print

}