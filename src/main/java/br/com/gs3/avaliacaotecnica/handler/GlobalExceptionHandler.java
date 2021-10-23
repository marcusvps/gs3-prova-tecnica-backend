package br.com.gs3.avaliacaotecnica.handler;


import br.com.gs3.avaliacaotecnica.dto.RetornoExceptionDTO;
import br.com.gs3.avaliacaotecnica.exception.AutenticacaoInvalidaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AutenticacaoInvalidaException.class)
    public ResponseEntity blogNotFoundException(AutenticacaoInvalidaException e) {
        e.setErrorCode(HttpStatus.UNAUTHORIZED.value());

        return new ResponseEntity(new RetornoExceptionDTO(e.getErrorMessage(),e.getErrorCode()), HttpStatus.UNAUTHORIZED);
    }
}

