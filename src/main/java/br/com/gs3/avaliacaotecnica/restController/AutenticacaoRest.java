package br.com.gs3.avaliacaotecnica.restController;

import br.com.gs3.avaliacaotecnica.dao.entity.Usuario;
import br.com.gs3.avaliacaotecnica.service.UsuarioService;
import br.com.gs3.avaliacaotecnica.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacaoRest {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/autenticar")
    public ResponseEntity<Usuario> autenticarUsuario(@RequestParam String login, @RequestParam String senha){
        return new ResponseEntity<>(usuarioService.recuperarUsuarioPor(login,senha), HttpStatus.OK);
    }
}
