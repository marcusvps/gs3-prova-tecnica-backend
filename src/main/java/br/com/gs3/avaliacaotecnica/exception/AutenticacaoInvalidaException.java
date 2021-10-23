package br.com.gs3.avaliacaotecnica.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AutenticacaoInvalidaException extends RuntimeException {
    private String message;

}
