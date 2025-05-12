/**
 * Esta interface indica as operações que uma classe 
 * que deseja ter o comportamento de ser Empilhavel precisa.
 * 
 * @author Mendes, M. N. S.
 * @version 1.1
 * @since 2025-05-05
 */

public interface EmpilhavelD <T> {

    //operações principais
    void empilhar(T dado); //push
    T desempilhar(); //pop
    T espiar(); //peek
    void atualizar(T dado); //update
    
    //operações auxiliares
    Boolean estaCheia(); //isFull
    Boolean estaVazia(); //isEmpty
    String imprimir(); //print

}