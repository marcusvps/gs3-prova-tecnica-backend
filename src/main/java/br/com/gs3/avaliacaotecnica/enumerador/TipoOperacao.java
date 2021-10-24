package br.com.gs3.avaliacaotecnica.enumerador;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoOperacao {
    INCLUSAO(1,"O usuário {user} realizou a ação de {tipo} em {data}."),
    REMOCAO(2,"O usuário {user} realizou a ação de {tipo} em {data}."),
    ALTERACAO(3, "O usuário {user} realizou a ação de {tipo} em {data}."),
    VISUALIZACAO(4, "O usuário {user} realizou a ação de {tipo} em {data}."),
    BUSCA_CEP(5, "O usuário {user} buscou os dados do CEP em {data} na API externa.")

    ;

    private int id;
    private String mensagem;


}
