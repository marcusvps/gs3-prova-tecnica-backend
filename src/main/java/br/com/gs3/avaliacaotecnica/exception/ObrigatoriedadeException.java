package br.com.gs3.avaliacaotecnica.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObrigatoriedadeException extends RuntimeException{
    private int errorCode;
    private String errorMessage;

    public ObrigatoriedadeException(String message) {
        super();
        this.errorMessage = message;
    }
}
