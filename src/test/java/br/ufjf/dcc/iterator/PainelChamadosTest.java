package br.ufjf.dcc.iterator;

import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class PainelChamadosTest {
    @Test void contaChamadosDeSituacoesDiferentes() {
        PainelChamados painel = new PainelChamados();
        painel.adicionar(new Chamado("Acesso", true));
        painel.adicionar(new Chamado("Rede", false));
        painel.adicionar(new Chamado("Impressora", true));
        RelatorioChamados relatorio = new RelatorioChamados();
        assertEquals(3, relatorio.contarTodos(painel));
        assertEquals(2, relatorio.contarAbertos(painel));
    }

    @Test void contaPainelVazio() {
        PainelChamados painel = new PainelChamados();
        RelatorioChamados relatorio = new RelatorioChamados();
        assertEquals(0, relatorio.contarTodos(painel));
        assertEquals(0, relatorio.contarAbertos(painel));
        assertFalse(painel.iterator().hasNext());
    }

    @Test void percorreNaOrdemEIndicaFim() {
        PainelChamados painel = new PainelChamados();
        painel.adicionar(new Chamado("Acesso", true));
        painel.adicionar(new Chamado("Rede", false));
        Iterator<Chamado> iterador = painel.iterator();
        assertEquals("Acesso", iterador.next().getDescricao());
        assertEquals("Rede", iterador.next().getDescricao());
        assertFalse(iterador.hasNext());
        assertThrows(NoSuchElementException.class, iterador::next);
    }

    @Test void iteradoresPercorremIndependentementeESemRemover() {
        PainelChamados painel = new PainelChamados();
        painel.adicionar(new Chamado("Acesso", true));
        Iterator<Chamado> primeiro = painel.iterator();
        Iterator<Chamado> segundo = painel.iterator();
        primeiro.next();
        assertTrue(segundo.hasNext());
        assertThrows(UnsupportedOperationException.class, primeiro::remove);
        assertEquals("Acesso", segundo.next().getDescricao());
    }
}
