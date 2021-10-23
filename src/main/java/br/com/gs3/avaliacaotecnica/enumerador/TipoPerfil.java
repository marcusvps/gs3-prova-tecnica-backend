package br.com.gs3.avaliacaotecnica.enumerador;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPerfil {
    ADMIN(1,"Administrador"),
    COMUM(2, "Comum");

    private int id;
    private String descricao;


}
