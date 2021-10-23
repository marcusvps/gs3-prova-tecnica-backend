package br.com.gs3.avaliacaotecnica.service.impl;

import br.com.gs3.avaliacaotecnica.dao.entity.Cliente;
import br.com.gs3.avaliacaotecnica.dao.repository.ClienteRepository;
import br.com.gs3.avaliacaotecnica.service.ClienteService;
import br.com.gs3.avaliacaotecnica.service.EmailService;
import br.com.gs3.avaliacaotecnica.service.EnderecoService;
import br.com.gs3.avaliacaotecnica.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private TelefoneService telefoneService;

    @Autowired
    private EmailService emailService;

    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente recuperarClientePor(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        return cliente;
    }

    @Override
    public Cliente salvar(Cliente novoCliente) {
        enderecoService.salvar(novoCliente.getEndereco());
        clienteRepository.save(novoCliente);
        emailService.salvarVariosEmails(novoCliente);
        telefoneService.salvarVariosTelefones(novoCliente);
        return novoCliente;
    }

    @Override
    public void remover(Cliente clienteARemover) {
        clienteRepository.delete(clienteARemover);
    }

    @Override
    public Cliente alterar(Cliente clienteASerAlterado) {
        return clienteRepository.save(clienteASerAlterado);
    }
}
