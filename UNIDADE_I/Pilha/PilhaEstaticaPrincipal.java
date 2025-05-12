public class PilhaEstaticaPrincipal {
    public static void main (String args[]) {
        //PilhaEstatica p1 = new PilhaEstatica(30);
        Empilhavel pilha = new PilhaEstatica(7); //mais indicado usar interface para preservar o código
        // o objeto Empilhavel não pode chamar métodos da classe PilhaEstatica

        pilha.empilhar("Instituto");
		pilha.empilhar("Federal");
		System.out.println("Espiar:" + pilha.espiar());		
		pilha.empilhar("de");
		pilha.empilhar("Educação");
		pilha.empilhar("Ciência");
		pilha.empilhar("e");		
		System.out.println("Espiar:" + pilha.espiar());		
		Object conteudo = pilha.desempilhar();
		pilha.desempilhar();
		pilha.empilhar("Tecnologia");
		pilha.empilhar("da");
		pilha.empilhar("Bahia");	
		pilha.empilhar(pilha.desempilhar());
		pilha.empilhar(conteudo);
		System.out.println("Pilha="+pilha.imprimir());
	}
    
}
