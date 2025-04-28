package Lista;

public class ListaEstaticaCircularPrincipal {
    public static void main(String[] args) {
        ListaEstaticaCircular l1 = new ListaEstaticaCircular(3);

        l1.anexar("mary");
        l1.anexar("nicole");
        l1.anexar("sousa");
        System.out.println(l1.apagar2(2));
        System.out.println(l1.imprimir());
        l1.anexar("mendes");
        System.out.println(l1.imprimir());
        System.out.println(l1.primeiraOcorrencia(3));
        System.out.println(l1.apagar2(1));
        l1.contem(3);
        System.out.println(l1.primeiraOcorrencia(3));
        System.out.println(l1.imprimir());

    }
}
