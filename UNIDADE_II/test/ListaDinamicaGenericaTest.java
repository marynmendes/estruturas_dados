import org.junit.Test;

import Excecao.OverflowException;
import Excecao.UnderflowException;
import Lista.ListaDinamicaGenerica;
import Lista.ListavelD;

import static org.junit.Assert.*;


public class ListaDinamicaGenericaTest {
    @Test
    public void testListaComDiferentesTipos(){
        ListavelD<Integer> listaInt = new ListaDinamicaGenerica<>(2);
        listaInt.anexar(1);
        listaInt.anexar(2);
        assertEquals(Integer.valueOf(1), listaInt.selecionar(0));
        
        ListavelD<Double> listaDouble = new ListaDinamicaGenerica<>(2);
        listaDouble.anexar(1.5);
        listaDouble.anexar(2.5);
        assertEquals(Double.valueOf(1.5), listaDouble.selecionar(0));
    }

     @Test
    public void testConstrutorPadrao() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>();
        for (int i = 0; i < 10; i++) {
            lista.anexar("Elemento" + i);
        }
        assertTrue(lista.estaCheia());
        try {
            lista.anexar("Extra");
            fail("Deveria ter lançado exceção de lista cheia!");
        } catch (OverflowException e) {
            assertEquals("Lista Cheia!", e.getMessage());
        }
    }

    @Test
    public void testConstrutorComTamanhoPersonalizado() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(5);
        for (int i = 0; i < 5; i++) {
            lista.anexar("Elemento" + i);
        }
        assertTrue(lista.estaCheia());
        try {
            lista.anexar("Extra");
            fail("Deveria ter lançado exceção de lista cheia!");
        } catch (OverflowException e) {
            assertEquals("Lista Cheia!", e.getMessage());
        }
    }

    @Test
    public void testAnexar() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        assertEquals("A", lista.selecionar(0));
        assertEquals("B", lista.selecionar(1));
        assertEquals("C", lista.selecionar(2));
    }

    @Test
    public void testInserir() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        lista.inserir("A", 0);
        lista.inserir("C", 1);
        lista.inserir("B", 1);
        assertEquals("A", lista.selecionar(0));
        assertEquals("B", lista.selecionar(1));
        assertEquals("C", lista.selecionar(2));
    }

    @Test
    public void testInserirPosicaoInvalida() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        try {
            lista.inserir("A", 1);
            fail("Deveria ter lançado exceção de índice inválido!");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Indice Invalido!", e.getMessage());
        }
    }


    @Test
    public void testSelecionar() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        assertEquals("A", lista.selecionar(0));
        assertEquals("B", lista.selecionar(1));
        assertEquals("C", lista.selecionar(2));
    }

    @Test
    public void testSelecionarPosicaoInvalida() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        lista.anexar("A");
        try {
            lista.selecionar(1);
            fail("Deveria ter lançado exceção de índice inválido!");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Indice Invalido!", e.getMessage());
        }
    }

    @Test
    public void testSelecionarTodos() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        Object[] elementos = lista.selecionarTodos();
        assertEquals(3, elementos.length);
        assertEquals("A", elementos[0]);
        assertEquals("B", elementos[1]);
        assertEquals("C", elementos[2]);
    }

    @Test
    public void testSelecionarTodosVazia() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        try {
            lista.selecionarTodos();
            fail("Deveria ter lançado exceção de lista vazia!");
        } catch (UnderflowException e) {
            assertEquals("Está vazia!", e.getMessage());
        }
    }

    @Test
    public void testAtualizar() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        lista.atualizar("X", 1);
        assertEquals("A", lista.selecionar(0));
        assertEquals("X", lista.selecionar(1));
        assertEquals("C", lista.selecionar(2));
    }

    @Test
    public void testAtualizarPosicaoInvalida() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        lista.anexar("A");
        try {
            lista.atualizar("X", 1 );
            fail("Deveria ter lançado exceção de índice inválido!");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Índice inválido!", e.getMessage());
        }
    }

    @Test
    public void testApagar() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        assertEquals("B", lista.apagar(1));
        assertEquals("A", lista.selecionar(0));
        assertEquals("C", lista.selecionar(1));
    }

    @Test
    public void testApagarPosicaoInvalida() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        lista.anexar("A");
        try {
            lista.apagar(1);
            fail("Deveria ter lançado exceção de índice inválido!");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Indice Invalido!", e.getMessage());
        }
    }


    @Test
    public void testEstaCheia() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(2);
        assertFalse(lista.estaCheia());
        lista.anexar("A");
        assertFalse(lista.estaCheia());
        lista.anexar("B");
        assertTrue(lista.estaCheia());
    }

    @Test
    public void testEstaVazia() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(2);
        assertTrue(lista.estaVazia());
        lista.anexar("A");
        assertFalse(lista.estaVazia());
        lista.apagar(0);
        assertTrue(lista.estaVazia());
    }

    @Test
    public void testImprimir() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(3);
        lista.anexar("A");
        lista.anexar("B");
        lista.anexar("C");
        assertEquals("[A,B,C]", lista.imprimir());
    }

    @Test
    public void testImprimirVazia() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(2);
        assertEquals("[]", lista.imprimir());
    }

    @Test
    public void testOperacoesCombinadas() {
        ListavelD<String> lista = new ListaDinamicaGenerica<>(5);
        lista.anexar("A");
        lista.inserir("B", 1);
        lista.anexar("C");
        lista.atualizar("X", 1);
        assertEquals("A", lista.selecionar(0));
        assertEquals("X", lista.selecionar(1));
        assertEquals("C", lista.selecionar(2));
        assertEquals("[A,X,C]", lista.imprimir());
    }
} 