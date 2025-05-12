package FilaPilha;

public class FilaComPilhas implements Enfileiravel{
    Empilhavel p1;
    Empilhavel p2;

    public FilaComPilhas(){
        this(10);
    }

    public FilaComPilhas(int tamanho){
        p1 = new PilhaEstatica(tamanho);
        p2 = new PilhaEstatica(tamanho);
    }

     @Override
    public void enfileirar(Object dado){
        if(!estaCheia()){
            p1.empilhar(dado);
        }
    }

    @Override
    public Object desenfileirar(){
        Object dadoInicio;
        while (!p1.estaVazia())
            p2.empilhar(p1.desempilhar());
        dadoInicio = p2.desempilhar();
        while (!p2.estaVazia())
            p1.empilhar(p2.desempilhar());
        return dadoInicio;
    }

    @Override
    public Object frente(){
        Object dadoInicio;
        while (!p1.estaVazia())
            p2.empilhar(p1.desempilhar());
        dadoInicio = p2.espiar();
        while (!p2.estaVazia())
            p1.empilhar(p2.desempilhar());
        return dadoInicio;
    }

    @Override
    public boolean estaCheia(){
        return p1.estaCheia();
    }

    @Override
    public boolean estaVazia(){
        return p1.estaVazia();
    }

    @Override
    public void atualizarInicio(Object dado){

    }

    @Override
    public void atualizarFim(Object dado){

    }

    @Override
    public String imprimir(){
        return p1.imprimir();
    }
}
