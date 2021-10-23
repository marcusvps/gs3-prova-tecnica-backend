package br.com.gs3.avaliacaotecnica.enumerador;

import lombok.Getter;

@Getter
public enum TipoTelefone {
    RESIDENCIAL(1,"Residencial","(xx) xxxx-xxxx"),
    COMERCIAL(1,"Comercial","(xx) xxxx-xxxx"),
    CELULAR(1,"Celular","(xx) xxxxx-xxxx");

    private int id;
    private String descricao;
    private String mascara;

    TipoTelefone(int id, String descricao, String mascara) {
        this.id = id;
        this.descricao = descricao;
        this.mascara = mascara;
    }
}
