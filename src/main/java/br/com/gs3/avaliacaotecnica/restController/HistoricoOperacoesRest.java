package br.com.gs3.avaliacaotecnica.restController;


import br.com.gs3.avaliacaotecnica.annotation.HistoricoOperacoesRegister;
import br.com.gs3.avaliacaotecnica.dao.entity.Cliente;
import br.com.gs3.avaliacaotecnica.dao.entity.HistoricoOperacoes;
import br.com.gs3.avaliacaotecnica.service.HistoricoOperacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/historico")
public class HistoricoOperacoesRest {

    @Autowired
    private HistoricoOperacoesService historicoOperacoesService;

    @HistoricoOperacoesRegister
    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<HistoricoOperacoes>> recuperarHistoricosPorUsuario(@PathVariable String idUsuario){
        return new ResponseEntity<>(historicoOperacoesService.findByUsuario(Long.valueOf(idUsuario)), HttpStatus.OK);
    }
}
