package br.com.gs3.avaliacaotecnica.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticacaoInvalidaException extends RuntimeException {
    private int errorCode;
    private String errorMessage;

    public AutenticacaoInvalidaException(String message, int errorCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public AutenticacaoInvalidaException(String message) {
        super();
        this.errorMessage = message;
    }
}
