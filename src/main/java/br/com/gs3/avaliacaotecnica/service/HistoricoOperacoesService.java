package br.com.gs3.avaliacaotecnica.service;

import br.com.gs3.avaliacaotecnica.dao.entity.HistoricoOperacoes;
import br.com.gs3.avaliacaotecnica.enumerador.TipoOperacao;

import java.util.List;

public interface HistoricoOperacoesService {

    HistoricoOperacoes criarHistorico(Long idUsuario, TipoOperacao tipoOperacao);
    void salvar(HistoricoOperacoes historicoOperacao);
    List<HistoricoOperacoes> findByUsuario(Long idUsuario);

}
