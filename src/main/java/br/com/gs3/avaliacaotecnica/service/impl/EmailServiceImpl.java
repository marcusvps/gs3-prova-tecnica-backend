package br.com.gs3.avaliacaotecnica.service.impl;

import br.com.gs3.avaliacaotecnica.dao.entity.Cliente;
import br.com.gs3.avaliacaotecnica.dao.entity.Email;
import br.com.gs3.avaliacaotecnica.dao.repository.EmailRepository;
import br.com.gs3.avaliacaotecnica.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public Email salvar(Email novoEmail) {
        return null;
    }

    @Override
    public List<Email> salvarVariosEmails(Cliente novoCliente) {
        return emailRepository.saveAll(novoCliente.getEmails());
    }

    @Override
    public void remover(Email emailARemover) {

    }

    @Override
    public Email alterar(Email emailASerAlterado) {
        return null;
    }
}
