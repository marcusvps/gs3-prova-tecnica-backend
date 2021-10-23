package br.com.gs3.avaliacaotecnica.service;

import br.com.gs3.avaliacaotecnica.dao.entity.Cliente;
import br.com.gs3.avaliacaotecnica.dao.entity.Email;
import br.com.gs3.avaliacaotecnica.exception.ObrigatoriedadeException;

import java.util.List;
import java.util.Set;

public interface EmailService {

    Email salvar(Email novoEmail);
    List<Email> salvarVariosEmails(Cliente novoCliente) throws ObrigatoriedadeException;
    void remover(Email emailARemover);
    Email alterar(Email emailASerAlterado);
}
