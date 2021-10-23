package br.com.gs3.avaliacaotecnica.enumerador;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {
    RESIDENCIAL(1,10,"Residencial"),
    COMERCIAL(2,10,"Comercial"),
    CELULAR(3,11,"Telefone");

    private int id;
    private int qtdCaracteres;
    private String descricao;


}
