package br.ufjf.dcc.iterator;

public class Chamado {
    private final String descricao;
    private final boolean aberto;

    public Chamado(String descricao, boolean aberto) {
        this.descricao = descricao;
        this.aberto = aberto;
    }

    public String getDescricao() { return descricao; }
    public boolean isAberto() { return aberto; }
}
