package br.ufjf.dcc.iterator;

import java.util.Iterator;

public class RelatorioChamados {
    public int contarTodos(PainelChamados painel) {
        int total = 0;
        Iterator<Chamado> iterador = painel.iterator();
        while (iterador.hasNext()) {
            iterador.next();
            total++;
        }
        return total;
    }

    public int contarAbertos(PainelChamados painel) {
        int total = 0;
        for (Chamado chamado : painel) {
            if (chamado.isAberto()) { total++; }
        }
        return total;
    }
}
