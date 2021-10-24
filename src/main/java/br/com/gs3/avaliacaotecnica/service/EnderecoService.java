package br.com.gs3.avaliacaotecnica.service;

import br.com.gs3.avaliacaotecnica.dao.entity.Endereco;

public interface EnderecoService {

    Endereco buscarDadosDeCEP(String cep);

}
