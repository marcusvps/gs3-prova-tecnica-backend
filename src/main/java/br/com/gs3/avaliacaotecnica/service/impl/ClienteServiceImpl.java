package br.com.gs3.avaliacaotecnica.service.impl;

import br.com.gs3.avaliacaotecnica.dao.entity.Cliente;
import br.com.gs3.avaliacaotecnica.dao.repository.ClienteRepository;
import br.com.gs3.avaliacaotecnica.enumerador.MensagensSistema;
import br.com.gs3.avaliacaotecnica.exception.ClienteDuplicadoException;
import br.com.gs3.avaliacaotecnica.exception.ClienteNotFoundException;
import br.com.gs3.avaliacaotecnica.service.ClienteService;
import br.com.gs3.avaliacaotecnica.service.HistoricoOperacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.gs3.avaliacaotecnica.enumerador.MensagensSistema.CLIENTE_JA_CADASTRADO;
import static br.com.gs3.avaliacaotecnica.enumerador.MensagensSistema.CLIENTE_NAO_ENCONTRADO_POR_ID;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;



    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente recuperarClientePor(String cpf) {
        return Optional.ofNullable(clienteRepository.findByCpf(cpf))
                .orElseThrow(() -> new ClienteNotFoundException(MensagensSistema
                        .CLIENTE_NAO_ENCONTRADO_POR_CPF
                        .getDescricao()
                        .replace("{cpf}",cpf)));

    }

    @Override
    public Cliente salvar(Cliente novoCliente) {
        try {
            clienteRepository.save(novoCliente);
            return novoCliente;
        } catch (DataIntegrityViolationException e) {
            throw new ClienteDuplicadoException(CLIENTE_JA_CADASTRADO.getDescricao().replace("{cpf}", novoCliente.getCpf()));
        }
    }

    @Override
    public void remover(Long idCliente) {
        try {
            clienteRepository.deleteById(idCliente);
        } catch (EmptyResultDataAccessException e) {
            throw new ClienteNotFoundException(CLIENTE_NAO_ENCONTRADO_POR_ID.getDescricao().replace("{id}",idCliente.toString()));
        }
    }

    @Override
    public Cliente alterar(Cliente clienteASerAlterado) {
        return clienteRepository.save(clienteASerAlterado);
    }
}
