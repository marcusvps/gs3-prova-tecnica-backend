package br.com.gs3.avaliacaotecnica.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteNotFoundException extends RuntimeException  {
    private String message;
}
