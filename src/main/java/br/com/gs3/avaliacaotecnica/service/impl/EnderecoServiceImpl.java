package br.com.gs3.avaliacaotecnica.service.impl;

import br.com.gs3.avaliacaotecnica.dao.entity.Endereco;
import br.com.gs3.avaliacaotecnica.dao.repository.EnderecoRepository;
import br.com.gs3.avaliacaotecnica.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    @Override
    public Object buscarDadosDeCEP() {
        return null;
    }

    @Override
    public Endereco salvar(Endereco novoEndereco) {
        return enderecoRepository.save(novoEndereco);
    }

    @Override
    public void remover(Endereco enderecoARemover) {

    }

    @Override
    public Endereco alterar(Endereco enderecoASerAlterado) {
        return null;
    }
}
