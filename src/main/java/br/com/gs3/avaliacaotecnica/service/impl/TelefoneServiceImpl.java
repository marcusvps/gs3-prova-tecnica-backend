package br.com.gs3.avaliacaotecnica.service.impl;

import br.com.gs3.avaliacaotecnica.dao.entity.Cliente;
import br.com.gs3.avaliacaotecnica.dao.entity.Telefone;
import br.com.gs3.avaliacaotecnica.dao.repository.TelefoneRepository;
import br.com.gs3.avaliacaotecnica.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneServiceImpl implements TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;


    @Override
    public Telefone salvar(Telefone novoTelefone) {
        return telefoneRepository.save(novoTelefone);
    }

    @Override
    public List<Telefone> salvarVariosTelefones(Cliente novoCliente) {
        return telefoneRepository.saveAll(novoCliente.getTelefones());
    }

    @Override
    public void remover(Telefone telefoneARemover) {

    }

    @Override
    public Telefone alterar(Telefone telefoneASerAlterado) {
        return null;
    }
}
