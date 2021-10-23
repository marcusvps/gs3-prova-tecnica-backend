package br.com.gs3.avaliacaotecnica.service;

import br.com.gs3.avaliacaotecnica.dao.entity.Usuario;

public interface UsuarioService {

    Usuario recuperarUsuarioPor(String login, String senha);
}
