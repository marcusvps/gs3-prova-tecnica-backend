package br.com.gs3.avaliacaotecnica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoIntegracaoDTO {


    private String logradouro;
    private String localidade;
    private String bairro;
    private String complemento;
    private String cep;
    private String uf;
}
