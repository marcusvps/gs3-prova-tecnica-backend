package br.com.gs3.avaliacaotecnica.enumerador;

import lombok.Getter;

@Getter
public enum MensagensSistema {
    ERRO_AUTENTICACAO_USUARIO("Usuário ou senha incorreta!"),
    EMAIL_OBRIGATORIEDADE("Ao menos um e-mail deve ser informado!"),
    TELEFONE_OBRIGATORIEDADE("Ao menos um telefone deve ser informado!"),
    CLIENTE_JA_CADASTRADO("CPF já cadastrado")

    ;

    private String descricao;

    MensagensSistema(String descricao) {
        this.descricao = descricao;
    }
}
