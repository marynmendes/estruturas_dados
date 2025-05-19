package Pilha;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PilhaDinamicaGenericaMain {
    public static void main(String[] args) {
    EmpilhavelD<String> pilha = new PilhaDinamicaGenerica<>(7);
    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
      exibirMenu();
      System.out.print("Escolha uma opção (0-5): ");
	  try {
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
          case 0 -> System.out.println("Saindo da Pilha. Até mais!");
          case 1 -> {
              System.out.print("Digite o valor: ");
              String valor = scanner.nextLine();
              try {
                  pilha.empilhar(valor);
              } catch(NoSuchElementException e) {
                  System.err.println(e.getMessage());
              }
              }
          case 2 -> {
              System.out.print("Deseja desempilhar[s/n]? ");
              String confirmacao = scanner.nextLine().trim().toLowerCase();
              if (confirmacao.equals("s")) {
                  try {
                      pilha.desempilhar();
                  } catch(NoSuchElementException e) {
                      System.err.println(e.getMessage());
                  }
              } }
          case 3 -> {
              try {
                  System.out.println("Topo: " + pilha.espiar());
              } catch(NoSuchElementException e) {
                  System.err.println(e.getMessage());
              }
              }
          case 4 -> {
              System.out.print("Digite o valor: ");
              String novoValor = scanner.nextLine();
              try {
                  pilha.atualizar(novoValor);
              } catch(NoSuchElementException e) {
                  System.err.println(e.getMessage());
              }
              }
          case 5 -> System.out.println(pilha.imprimir());
          default -> System.out.println("Opção inválida. Tente novamente.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Tente novamente.");
        scanner.nextLine();
        opcao = -1;
      }		
    } while (opcao != 0);

    scanner.close();
  }

  public static void exibirMenu() {
    System.out.println("""
            ---------MENU---------
            0: SAIR
            1: EMPILHAR
            2: DESEMPILHAR
            3: ESPIAR
            4: ATUALIZAR
            5: IMPRIMIR
            ----------------------
            """);
  }
}
