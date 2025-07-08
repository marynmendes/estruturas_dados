import org.junit.Test;

import Fila.EnfileiravelD;
import Fila.FilaDinamicaGenerica;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;


public class FilaDinamicaGenericaTest {


  @Test
  public void testFilaComDiferentesTipos() {
    EnfileiravelD<Integer> filaInt = new FilaDinamicaGenerica<>(2);
    filaInt.enfileirarFim(1);
    filaInt.enfileirarFim(2);
    assertEquals(Integer.valueOf(1), filaInt.frente());
    
    EnfileiravelD<Double> filaDouble = new FilaDinamicaGenerica<>(2);
    filaDouble.enfileirarFim(1.5);
    filaDouble.enfileirarFim(2.5);
    assertEquals(Double.valueOf(1.5), filaDouble.frente());
  }

  @Test
  public void testConstrutorPadrao() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>();
    // Deve permitir 10 elementos
    for (int i = 0; i < 10; i++) {
        fila.enfileirarFim("Elemento" + i);
    }
    try {
        fila.enfileirarFim("Extra");
        fail("Deveria ter lançado exceção de fila cheia!");
    } catch (NoSuchElementException e) {
        assertEquals("Fila está cheia!", e.getMessage());
    }
  }

  @Test
  public void testConstrutorComTamanhoPersonalizado() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(5);
    // Deve permitir 5 elementos
    for (int i = 0; i < 5; i++) {
        fila.enfileirarFim("Elemento" + i);
    }
    try {
        fila.enfileirarFim("Extra");
        fail("Deveria ter lançado exceção de fila cheia!");
    } catch (NoSuchElementException e) {
        assertEquals("Fila está cheia!", e.getMessage());
    }
  }

  @Test
  public void testEnfileirar() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    fila.enfileirarFim("Instituto");  
    assertEquals("Instituto", fila.frente());
  }

  @Test
  public void testEnfileirarMultiplosElementos() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(3);
      fila.enfileirarFim("A");
      fila.enfileirarFim("B");
      fila.enfileirarFim("C");
      assertEquals("A", fila.frente());
      assertEquals("[A, B, C]", fila.imprimirFrenteTras());
  }

  @Test
  public void testDesenfileirar() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    fila.enfileirarFim("Instituto");
    String conteudo = fila.desenfileirarInicio();
    assertEquals("Instituto", conteudo);
  }

  @Test
  public void testDesenfileirarMultiplosElementos() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(3);
    fila.enfileirarFim("A");
    fila.enfileirarFim("B");
    fila.enfileirarFim("C");
    assertEquals("A", fila.desenfileirarInicio());
    assertEquals("B", fila.desenfileirarInicio());
    assertEquals("C", fila.frente());
  }

  @Test
  public void testFrente() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(5);
    fila.enfileirarFim("Instituto");
    fila.enfileirarFim("Federal");
    assertEquals("Instituto", fila.frente());
  }

  @Test
  public void testAtualizarInicio() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    fila.enfileirarFim("Instituto");
    fila.atualizarInicio("Universidade");
    assertEquals("Universidade", fila.frente());
  }

  @Test
  public void testAtualizarInicioComMultiplosElementos() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(3);
    fila.enfileirarFim("Primeiro");
    fila.enfileirarFim("Segundo");
    fila.enfileirarFim("Terceiro");
    fila.atualizarInicio("Novo");
    assertEquals("Novo", fila.frente());
    fila.desenfileirarInicio();
    assertEquals("Segundo", fila.frente());
  }

  @Test
  public void testAtualizarFim() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    fila.enfileirarFim("Instituto");
    fila.atualizarInicio("Universidade");
    assertEquals("Universidade", fila.frente());
  }

  @Test
  public void testAtualizarFimComMultiplosElementos() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(3);
    fila.enfileirarFim("Primeiro");
    fila.enfileirarFim("Segundo");
    fila.enfileirarFim("Terceiro");
    fila.atualizarFim("Novo");
    assertEquals("Primeiro", fila.frente());
    fila.desenfileirarInicio();
    fila.desenfileirarInicio();
    assertEquals("Novo", fila.frente());
  }

  @Test
  public void testImprimirDeFrentePraTras() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(5);
    fila.enfileirarFim("Instituto");
    fila.enfileirarFim("Federal");
    fila.enfileirarFim("de");
    String resultado = fila.imprimirFrenteTras();
    assertTrue(resultado.contains("Instituto"));
    assertTrue(resultado.contains("Federal"));
    assertTrue(resultado.contains("de"));
  }

  @Test
  public void testImprimirDeFrentePraTrasVaziaFormatacaoVazia() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(2);
    assertEquals("[]", fila.imprimirFrenteTras());
  }
  
  @Test
  public void testImprimirDeFrentePraTrasFormatacao() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(3);
    fila.enfileirarFim("A");
    fila.enfileirarFim("B");
    fila.enfileirarFim("C");
    assertEquals("[A, B, C]", fila.imprimirFrenteTras());
  }

  @Test
  public void testEstaCheia() {
      EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(2);
      assertFalse(fila.estaCheia());
      fila.enfileirarFim("Primeiro");
      assertFalse(fila.estaCheia());
      fila.enfileirarFim("Segundo");
      assertTrue(fila.estaCheia());
  }
  
  @Test
  public void testEstaVazia() {
      EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(2);
      assertTrue(fila.estaVazia());
      fila.enfileirarFim("Primeiro");
      assertFalse(fila.estaVazia());
      fila.desenfileirarInicio();
      assertTrue(fila.estaVazia());
  }

  @Test
  public void testFilaCheiaEnfileirar() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    fila.enfileirarFim("Instituto");
    try {
        fila.enfileirarFim("Federal");// deve lançar exceção
		    //Se chegou aqui, a exceção não foi lançada!
        fail("Deveria ter acontecido um overflow!");
    } catch (NoSuchElementException e) {
        assertEquals("Fila está cheia!", e.getMessage());
	  }
  }
  
  @Test
  public void testFilaVaziaDesenfileirar() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    fila.enfileirarFim("Instituto");
    fila.desenfileirarInicio();
    try {
        fila.desenfileirarInicio(); // deve lançar exceção
		    //Se chegou aqui, a exceção não foi lançada!
        fail("Deveria ter acontecido um underflow!");
    } catch (NoSuchElementException e) {
        assertEquals("Fila está vazia", e.getMessage());
	  }
  } 

  @Test
  public void testFilaVaziaFrente() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    fila.enfileirarFim("Instituto");
    fila.desenfileirarInicio();
    try {
        fila.frente(); // deve lançar exceção
		    //Se chegou aqui, a exceção não foi lançada!
        fail("Deveria ter acontecido um underflow!");
    } catch (NoSuchElementException e) {
        assertEquals("Fila está vazia.", e.getMessage());
	  }
  }

  @Test
  public void testFilaVaziaAtualizarInicio() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    fila.enfileirarFim("Instituto");
    fila.desenfileirarInicio();
    try {
        fila.atualizarInicio("Universidade"); // deve lançar exceção
		    //Se chegou aqui, a exceção não foi lançada!
        fail("Deveria ter acontecido um underflow!");
    } catch (NoSuchElementException e) {
        assertEquals("Fila está vazia.", e.getMessage());
	  }
  }

  @Test
  public void testFilaVaziaAtualizarFim() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    fila.enfileirarFim("Instituto");
    fila.desenfileirarInicio();
    try {
        fila.atualizarFim("Universidade"); // deve lançar exceção
		    //Se chegou aqui, a exceção não foi lançada!
        fail("Deveria ter acontecido um underflow!");
    } catch (NoSuchElementException e) {
        assertEquals("Fila está vazia.", e.getMessage());
	  }
  }
  
	@Test
	public void testOperacaoNaoSuportadaEnfileirarInicio() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    try {
      fila.enfileirarInicio("Instituto");
		  //Se chegou aqui, a exceção não foi lançada!
      fail("Deveria ter lançado uma exceção!");
    } catch (UnsupportedOperationException e) {
      assertEquals("Operação não suportada.", e.getMessage());
	  }
	}

	@Test
	public void testOperacaoNaoSuportadaDesenfileirarFim() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    try {
      fila.desenfileirarFim();
		  //Se chegou aqui, a exceção não foi lançada!
      fail("Deveria ter lançado uma exceção!");
    } catch (UnsupportedOperationException e) {
      assertEquals("Operação não suportada.", e.getMessage());
	  }
	}

	@Test
	public void testOperacaoNaoSuportadaTras() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    try {
      fila.tras();
		  //Se chegou aqui, a exceção não foi lançada!
      fail("Deveria ter lançado uma exceção!");
    } catch (UnsupportedOperationException e) {
      assertEquals("Operação não suportada.", e.getMessage());
	  }
	}

	@Test
	public void testOperacaoNaoSuportadaImprimirDeTrasPraFrente() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(1);
    try {
      fila.imprimirTrasFrente();
		  //Se chegou aqui, a exceção não foi lançada!
      fail("Deveria ter lançado uma exceção!");
    } catch (UnsupportedOperationException e) {
      assertEquals("Operação não suportada.", e.getMessage());
	  }
	}

  @Test
  public void testLimpezaFila() {
    EnfileiravelD<String> fila = new FilaDinamicaGenerica<>(2);
    fila.enfileirarFim("A");
    fila.enfileirarFim("B");
    fila.desenfileirarInicio();
    fila.desenfileirarInicio();
    assertTrue(fila.estaVazia());
    try {
        fila.frente();
        fail("Deveria ter lançado exceção de fila vazia!");
    } catch (NoSuchElementException e) {
        assertEquals("Fila está vazia.", e.getMessage());
    }
  }
}
