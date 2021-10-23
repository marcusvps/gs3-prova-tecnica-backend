package br.com.gs3.avaliacaotecnica.enumerador;

public enum TipoPerfil {
    ADMIN(1,"Administrador"),
    COMUM(2, "Comum");

    private int id;
    private String descricao;

    TipoPerfil(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
