package br.com.gs3.avaliacaotecnica.handler;


import br.com.gs3.avaliacaotecnica.dto.RetornoExceptionDTO;
import br.com.gs3.avaliacaotecnica.exception.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.support.DefaultMessageSourceResolvable;
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
    public ResponseEntity<RetornoExceptionDTO> unauthorized(AutenticacaoInvalidaException e) {
        return new ResponseEntity<>(new RetornoExceptionDTO(e.getMessage(),HttpStatus.UNAUTHORIZED.value()),HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = ObrigatoriedadeException.class)
    public ResponseEntity<RetornoExceptionDTO> unprocessableEntity(ObrigatoriedadeException e) {
        return new ResponseEntity<>(new RetornoExceptionDTO(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY.value()),HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = ClienteDuplicadoException.class)
    public ResponseEntity<RetornoExceptionDTO> uniqueConstraint(ClienteDuplicadoException e) {

        return new ResponseEntity<>(new RetornoExceptionDTO(e.getMessage(),HttpStatus.CONFLICT.value()),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ClienteNotFoundException.class)
    public ResponseEntity<RetornoExceptionDTO> clientNotFound(ClienteNotFoundException e) {
        return new ResponseEntity<>(new RetornoExceptionDTO(e.getMessage(),HttpStatus.NOT_FOUND.value()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IntegracaoExternaException.class)
    public ResponseEntity<RetornoExceptionDTO> integracaoExternaErro(IntegracaoExternaException e) {
        return new ResponseEntity<>(new RetornoExceptionDTO(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value()),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<RetornoExceptionDTO> argumentoNotValid(MethodArgumentNotValidException e) {
        List<String> erros = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new RetornoExceptionDTO(erros,HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST);
    }



}

