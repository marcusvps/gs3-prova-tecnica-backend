package br.com.gs3.avaliacaotecnica.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class RetornoExceptionDTO {

    private String erro;
    private int codigoErro;
    private List<String> erros;

    public RetornoExceptionDTO(String erro, int codigoErro) {
        this.erro = erro;
        this.codigoErro = codigoErro;
    }

    public RetornoExceptionDTO(List<String> erros, int codigoErro) {
        this.erros = erros;
        this.codigoErro = codigoErro;
    }


}
