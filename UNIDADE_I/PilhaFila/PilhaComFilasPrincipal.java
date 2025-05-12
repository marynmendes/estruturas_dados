package PilhaFila;

public class PilhaComFilasPrincipal {
    public static void main(String[] args) {
        Empilhavel pilhaFila = new PilhaComFilas(7);

        pilhaFila.empilhar("Instituto");
		pilhaFila.empilhar("Federal");
		System.out.println("Espiar:" + pilhaFila.espiar());		
		pilhaFila.empilhar("de");
		pilhaFila.empilhar("Educação");
		pilhaFila.empilhar("Ciência");
		pilhaFila.empilhar("e");		
		System.out.println("Espiar:" + pilhaFila.espiar());		
		Object conteudo = pilhaFila.desempilhar();
		pilhaFila.desempilhar();
		pilhaFila.empilhar("Tecnologia");
		pilhaFila.empilhar("da");
		pilhaFila.empilhar("Bahia");	
		pilhaFila.empilhar(pilhaFila.desempilhar());
		pilhaFila.empilhar(conteudo);
		System.out.println("Pilha com Fila ="+pilhaFila.imprimir());

        // Espiar:Federal
        // Espiar:e
        // Stack is full!
        // Pilha com Fila =[Bahia,da,Tecnologia,Educação,de,Federal,Instituto]
        //
        //
        // Obs: usei os mesmos comandos da PilhaEstáticaPrincipal para conferir o funcionamento da pilha com filas
    }
}
