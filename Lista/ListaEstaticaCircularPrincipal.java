package Lista;

public class ListaEstaticaCircularPrincipal {
    public static void main(String[] args) {
        Listavel l1 = new ListaEstaticaCircular(4);

        l1.anexar(1);
        l1.anexar(2);
        l1.anexar(3);
        l1.anexar(4);
        System.out.println(l1.imprimir());
        l1.contem(3);
        System.out.println(l1.primeiraOcorrencia(3));
        l1.apagar(2);
        l1.contem(3);
        System.out.println(l1.primeiraOcorrencia(3));
        System.out.println(l1.imprimir());

    }
}
