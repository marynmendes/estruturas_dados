public class ABP<T extends Comparable<T>> implements Arborizavel<T>{
    private NoTriplo<T> raiz;

    public ABP() {
    raiz = null;
    }

    @Override
    public NoTriplo<T> getRaiz() {
        return raiz;
    }

    @Override
    public void inserir(T dado) {
        NoTriplo<T> novoNo = new NoTriplo<>(dado);

        if (raiz == null) {
            raiz = novoNo;
        } else {
            NoTriplo<T> noAuxiliar = raiz;
            while (true) {
                int comparacao = dado.compareTo(noAuxiliar.getDado());
                if (comparacao <= 0) {
                    if (noAuxiliar.getEsquerda() == null) {
                        noAuxiliar.setEsquerda(novoNo);
                        novoNo.setPai(noAuxiliar);
                        break;
                    }
                    noAuxiliar = noAuxiliar.getEsquerda();
                } else {
                    if (noAuxiliar.getDireita() == null) {
                        noAuxiliar.setDireita(novoNo);
                        novoNo.setPai(noAuxiliar);
                        break;
                    }
                    noAuxiliar = noAuxiliar.getDireita();
                }
            }
        }
    }

    @Override
    public T apagar(T dado) {
        NoTriplo<T> noAuxiliar = buscar(dado);

        if (noAuxiliar == null)   
            return null;
        if (noAuxiliar.getEsquerda() == null &&
                noAuxiliar.getDireita() == null)
            apagarNoFolha(noAuxiliar);
        else if (noAuxiliar.getEsquerda() == null ||
                noAuxiliar.getDireita() == null)
            apagarComUmFilho(noAuxiliar);
        else
            apagarComDoisFilhos(noAuxiliar);

        return dado;
    }

    private void apagarNoFolha(NoTriplo<T> nodo) {
        NoTriplo<T> pai = nodo.getPai();
        if (pai == null) {
            raiz = null;
        } else {
            if (nodo.equals(pai.getEsquerda()))
                pai.setEsquerda(null);
            else       
                pai.setDireita(null);
        }
    }

    private void apagarComUmFilho(NoTriplo<T> nodo) {
        NoTriplo<T> avo = nodo.getPai();
        NoTriplo<T> neto = ((nodo.getEsquerda() != null) ? nodo.getEsquerda() : nodo.getDireita());        
        if (avo == null) {
            raiz = neto;
            raiz.setPai(null);
        } else {
            neto.setPai(avo);
            if (nodo.equals(avo.getEsquerda())) {
                avo.setEsquerda(neto);
            } else {
                avo.setDireita(neto);
            }
        }
    }

    private void apagarComDoisFilhos(NoTriplo<T> nodo) {
        NoTriplo<T> noSucessor = encontraMenorDireita(nodo);
        nodo.setDado(noSucessor.getDado());
        if (noSucessor.getEsquerda() == null && 
        noSucessor.getDireita() == null) {
            apagarNoFolha(noSucessor);
        } else {
            apagarComUmFilho(noSucessor);
        }
    }

    private NoTriplo<T> encontraMenorDireita(NoTriplo<T> nodo) {
    NoTriplo<T> noAuxiliar = nodo.getDireita();
    while (noAuxiliar.getEsquerda() != null)
        noAuxiliar = noAuxiliar.getEsquerda();

    return noAuxiliar;
    }  

    private NoTriplo<T> encontraMaiorEsquerda(NoTriplo<T> nodo) {
        NoTriplo<T> noAuxiliar = nodo.getEsquerda();
        while (noAuxiliar.getDireita() != null)
            noAuxiliar = noAuxiliar.getDireita();

        return noAuxiliar;
    } 

    @Override
    public boolean existe(T dado) {
        return buscar(dado) != null;
    }

    private NoTriplo<T> buscar(T dado) {
        NoTriplo<T> noAuxiliar = raiz;
        while (noAuxiliar != null) {
            int comparacao = dado.compareTo(noAuxiliar.getDado());
            if (comparacao == 0) 
                return noAuxiliar;
                noAuxiliar = ((comparacao <= 0) ? noAuxiliar.getEsquerda() : noAuxiliar.getDireita());
        }
        return null;
    }

    @Override
    public void limpar() {
        raiz=null;
    }

    @Override
    public String imprimirPreOrdem() {
        return formataSaida(imprimirPreOrdemRec(raiz));
    }

    @Override
    public String imprimirEmOrdem() {
        return formataSaida(imprimirEmOrdemRec(raiz));
    }

    @Override
    public String imprimirPosOrdem() {
    return formataSaida(imprimirPosOrdemRec(raiz));
    }

    private String imprimirPreOrdemRec(NoTriplo<T> raizAtual) {
        if (raizAtual == null) return ""; 
        return raizAtual.getDado() + " " + 
                imprimirPreOrdemRec(raizAtual.getEsquerda()) +  " " +
                imprimirPreOrdemRec(raizAtual.getDireita());
    }

    private String imprimirEmOrdemRec(NoTriplo<T> raizAtual) {
        if (raizAtual == null) return "";
        return imprimirEmOrdemRec(raizAtual.getEsquerda()) + " " + 
                raizAtual.getDado() + " " +
                imprimirEmOrdemRec(raizAtual.getDireita());    
    }

    private String imprimirPosOrdemRec(NoTriplo<T> raizAtual) {
        if (raizAtual == null) return ""; 
        return imprimirPosOrdemRec(raizAtual.getEsquerda()) + " " +
                imprimirPosOrdemRec(raizAtual.getDireita()) +  " " +
                raizAtual.getDado();           
    }

    private String formataSaida(String msg) {
        String resultado;
        do {
            resultado = msg;
            msg = msg.replace("  ", " "); 
        } while (!msg.equals(resultado));
        msg = msg.trim(); 
        msg = msg.replace(" ", ","); 
        return "[" + msg + "]";
    }
    
}
