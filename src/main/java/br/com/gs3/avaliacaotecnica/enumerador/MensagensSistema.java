package br.com.gs3.avaliacaotecnica.enumerador;

import lombok.Getter;

@Getter
public enum MensagensSistema {
    ERRO_AUTENTICACAO_USUARIO("Usuário ou senha incorreta!");

    private String descricao;

    MensagensSistema(String descricao) {
        this.descricao = descricao;
    }
}
