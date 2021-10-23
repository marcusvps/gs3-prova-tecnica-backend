package br.com.gs3.avaliacaotecnica.enumerador;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoOperacao {
    INCLUSAO(1,"O usuário {user} realizou a inclusão de {tipo} em {data}."),
    REMOCAO(2,"O usuário {user} realizou a remoção de {tipo} em {data}."),
    ALTERACAO(3, "O usuário {user} realizou a alteração de {tipo} em {data}."),
    VISUALIZACAO(4, "O usuário {user} realizou a visualização de {tipo} em {data}.");

    private int id;
    private String mensagem;


}
