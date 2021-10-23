package br.com.gs3.avaliacaotecnica.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RetornoExceptionDTO {

    private String erro;
    private int codigoErro;

    public RetornoExceptionDTO(String erro, int codigoErro) {
        this.erro = erro;
        this.codigoErro = codigoErro;
    }


}
