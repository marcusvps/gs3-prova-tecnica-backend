package br.com.gs3.avaliacaotecnica.enumerador;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MensagensSistema {
    ERRO_AUTENTICACAO_USUARIO("Usuário ou senha incorreta!"),
    EMAIL_OBRIGATORIEDADE("Ao menos um e-mail deve ser informado!"),
    TELEFONE_OBRIGATORIEDADE("Ao menos um telefone deve ser informado!"),
    CLIENTE_JA_CADASTRADO("CPF {cpf} já cadastrado."),
    CLIENTE_DUPLICADO("Cliente com id: {id} não encontrado!"),
    CLIENTE_REMOVIDO("Cliente removido com sucesso!")

    ;

    private String descricao;


}
