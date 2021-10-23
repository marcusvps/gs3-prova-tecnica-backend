package br.com.gs3.avaliacaotecnica.service;

import br.com.gs3.avaliacaotecnica.dao.entity.Cliente;
import br.com.gs3.avaliacaotecnica.dao.entity.Telefone;

import java.util.List;

public interface TelefoneService {

    Telefone salvar(Telefone novoTelefone);
    List<Telefone> salvarVariosTelefones(Cliente novoCliente);
    void remover(Telefone telefoneARemover);
    Telefone alterar(Telefone telefoneASerAlterado);
}
