package br.com.gs3.avaliacaotecnica.service;

import br.com.gs3.avaliacaotecnica.dao.entity.Cliente;

import java.util.List;

public interface ClienteService{

    List<Cliente> findAllClientes();
    Cliente recuperarClientePor(String cpf);
    Cliente salvar(Cliente novoCliente);
    void remover(Cliente clienteARemover);
    Cliente alterar(Cliente clienteASerAlterado);
}
