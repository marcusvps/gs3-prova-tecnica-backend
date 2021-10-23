package br.com.gs3.avaliacaotecnica.handler;


import br.com.gs3.avaliacaotecnica.dto.RetornoExceptionDTO;
import br.com.gs3.avaliacaotecnica.enumerador.MensagensSistema;
import br.com.gs3.avaliacaotecnica.exception.AutenticacaoInvalidaException;
import br.com.gs3.avaliacaotecnica.exception.ObrigatoriedadeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AutenticacaoInvalidaException.class)
    public ResponseEntity unauthorized(AutenticacaoInvalidaException e) {
        return new ResponseEntity(new RetornoExceptionDTO(e.getErrorMessage(),HttpStatus.UNAUTHORIZED.value()),HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = ObrigatoriedadeException.class)
    public ResponseEntity unprocessableEntity(ObrigatoriedadeException e) {
        return new ResponseEntity(new RetornoExceptionDTO(e.getErrorMessage(),HttpStatus.UNPROCESSABLE_ENTITY.value()),HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity argumentoNotValid(MethodArgumentNotValidException e) {
        List<String> erros = e.getBindingResult().getAllErrors().stream().map(ex -> ex.getDefaultMessage()).collect(Collectors.toList());
        return new ResponseEntity(new RetornoExceptionDTO(erros,HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity uniqueConstraint(DataIntegrityViolationException e) {
        String mensagemErro = "";
        if(isErroNaColunaCPF(e)){
            mensagemErro = MensagensSistema.CLIENTE_JA_CADASTRADO.getDescricao();
        }
        return new ResponseEntity(new RetornoExceptionDTO(mensagemErro,HttpStatus.CONFLICT.value()),HttpStatus.CONFLICT);
    }

    private boolean isErroNaColunaCPF(DataIntegrityViolationException e) {
        return e.getCause().getCause().getMessage().contains("cpf");
    }


}

