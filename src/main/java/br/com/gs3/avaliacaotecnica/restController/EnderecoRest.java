package br.com.gs3.avaliacaotecnica.restController;

import br.com.gs3.avaliacaotecnica.dao.entity.Endereco;
import br.com.gs3.avaliacaotecnica.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/endereco/")
public class EnderecoRest {

    @Autowired
    private EnderecoService enderecoService;


    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> buscarCep(@PathVariable String cep){
        return new ResponseEntity<>(enderecoService.buscarDadosDeCEP(cep), HttpStatus.OK);
    }


}
