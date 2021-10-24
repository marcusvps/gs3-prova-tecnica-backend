package br.com.gs3.avaliacaotecnica.restController;

import br.com.gs3.avaliacaotecnica.annotation.HistoricoOperacoesRegister;
import br.com.gs3.avaliacaotecnica.dao.entity.Cliente;
import br.com.gs3.avaliacaotecnica.dao.entity.Usuario;
import br.com.gs3.avaliacaotecnica.enumerador.TipoOperacao;
import br.com.gs3.avaliacaotecnica.service.ClienteService;
import br.com.gs3.avaliacaotecnica.service.HistoricoOperacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static br.com.gs3.avaliacaotecnica.enumerador.MensagensSistema.CLIENTE_REMOVIDO;

@RestController
@RequestMapping("api/cliente")
public class ClienteRest {

    @Autowired
    private ClienteService clienteService;


    @HistoricoOperacoesRegister
    @GetMapping()
    public ResponseEntity<List<Cliente>> recuperarTodosOsClientes(){
        return new ResponseEntity<>(clienteService.findAllClientes(), HttpStatus.OK);
    }

    @HistoricoOperacoesRegister
    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> recuperarCliente(@PathVariable String cpf){
        return new ResponseEntity<>(clienteService.recuperarClientePor(cpf), HttpStatus.OK);
    }

    @HistoricoOperacoesRegister(tipoOperacao = TipoOperacao.INCLUSAO)
    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente novoCliente){
        return new ResponseEntity<>(clienteService.salvar(novoCliente), HttpStatus.OK);
    }

    @HistoricoOperacoesRegister(tipoOperacao = TipoOperacao.ALTERACAO)
    @PutMapping("/alterar")
    public ResponseEntity<Cliente> alterar(@Valid @RequestBody Cliente clienteASerAlterado){
        return new ResponseEntity<>(clienteService.alterar(clienteASerAlterado), HttpStatus.OK);
    }

    @HistoricoOperacoesRegister(tipoOperacao = TipoOperacao.REMOCAO)
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> remover(@PathVariable Long id){
        clienteService.remover(id);
        return new ResponseEntity<>(CLIENTE_REMOVIDO.getDescricao(), HttpStatus.OK);
    }

}
