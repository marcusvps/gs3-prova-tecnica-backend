package br.com.gs3.avaliacaotecnica.restController;

import br.com.gs3.avaliacaotecnica.dao.entity.Cliente;
import br.com.gs3.avaliacaotecnica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ClienteRest {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/{cpf}")
    public ResponseEntity<Cliente> recuperarCliente(@PathVariable String cpf){
        return new ResponseEntity<>(clienteService.recuperarClientePor(cpf), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente novoCliente){
        return new ResponseEntity<>(clienteService.salvar(novoCliente), HttpStatus.OK);
    }

    @PutMapping("/alterar")
    public ResponseEntity<Cliente> alterar(@Valid @RequestBody Cliente clienteASerAlterado){
        return new ResponseEntity<>(clienteService.alterar(clienteASerAlterado), HttpStatus.OK);
    }

}
