package br.ufjf.dcc.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class PainelChamados implements Iterable<Chamado> {
    private final List<Chamado> chamados = new ArrayList<>();

    public void adicionar(Chamado chamado) {
        chamados.add(Objects.requireNonNull(chamado));
    }

    @Override
    public Iterator<Chamado> iterator() {
        return Collections.unmodifiableList(chamados).iterator();
    }
}
