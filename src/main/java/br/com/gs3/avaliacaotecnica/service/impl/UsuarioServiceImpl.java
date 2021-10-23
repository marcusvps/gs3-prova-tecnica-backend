package br.com.gs3.avaliacaotecnica.service.impl;

import br.com.gs3.avaliacaotecnica.dao.entity.Usuario;
import br.com.gs3.avaliacaotecnica.dao.repository.UsuarioRepository;
import br.com.gs3.avaliacaotecnica.enumerador.MensagensSistema;
import br.com.gs3.avaliacaotecnica.exception.AutenticacaoInvalidaException;
import br.com.gs3.avaliacaotecnica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public Usuario recuperarUsuarioPor(String login, String senha) throws AutenticacaoInvalidaException {
        return Optional
                .ofNullable(repository.findByLoginAndSenha(login.toLowerCase(), senha))
                .orElseThrow(() -> new AutenticacaoInvalidaException(MensagensSistema.ERRO_AUTENTICACAO_USUARIO.getDescricao()));
    }
}
