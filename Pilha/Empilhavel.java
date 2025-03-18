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

/*CONJUNTO BÁSICO DE ESTRUTURA DE DADOS
C- create (criar)
R- read (ler)
U- update (atualizar)
D- delete (apagar)
S- sort (ordenar)

-----------------------------------------

TIPOS DE DADOS
- Numéricos
    - inteiros
        - unsigned int
        - tinyint, smallint
        - int
        - long, longint, bigint
    - ponto flutuante
        - float
        - double
    - ponto fixo
- String
- Char
- Lógico
    - boolean, bool
- Vetor, array, matriz unidimensional
- Ponteiro
- Objeto
*/