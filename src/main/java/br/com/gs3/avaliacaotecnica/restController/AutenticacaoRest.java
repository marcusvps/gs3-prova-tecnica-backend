package br.com.gs3.avaliacaotecnica.restController;

import br.com.gs3.avaliacaotecnica.annotation.HistoricoOperacoesRegister;
import br.com.gs3.avaliacaotecnica.dao.entity.Usuario;
import br.com.gs3.avaliacaotecnica.enumerador.TipoOperacao;
import br.com.gs3.avaliacaotecnica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/autenticar")
@RestController
public class AutenticacaoRest {

    @Autowired
    private UsuarioService usuarioService;


    @HistoricoOperacoesRegister(tipoOperacao = TipoOperacao.LOGIN)
    @GetMapping()
    @CrossOrigin
    public ResponseEntity<Usuario> autenticarUsuario(@RequestParam String login, @RequestParam String senha){
        return new ResponseEntity<>(usuarioService.recuperarUsuarioPor(login,senha), HttpStatus.OK);
    }
}
