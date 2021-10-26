package br.com.gs3.avaliacaotecnica.service.impl;

import br.com.gs3.avaliacaotecnica.dao.entity.HistoricoOperacoes;
import br.com.gs3.avaliacaotecnica.dao.entity.Usuario;
import br.com.gs3.avaliacaotecnica.dao.repository.HistoricoOperacoesRepository;
import br.com.gs3.avaliacaotecnica.enumerador.TipoOperacao;
import br.com.gs3.avaliacaotecnica.service.HistoricoOperacoesService;
import br.com.gs3.avaliacaotecnica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class HistoricoOperacoesImpl implements HistoricoOperacoesService {

    @Autowired
    private HistoricoOperacoesRepository historicoOperacoesRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public HistoricoOperacoes criarHistorico(Long idUsuario, TipoOperacao tipoOperacao) {
        Usuario user = usuarioService.recuperarUsuarioPor(idUsuario);
        HistoricoOperacoes novoHistorico = new HistoricoOperacoes();
        novoHistorico.setUsuario(user);
        novoHistorico.setDataOperacao(LocalDateTime.now());
        novoHistorico.setTipoOperacao(tipoOperacao);


        String formattedDate = novoHistorico.getDataOperacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        String descricaoFormatada = tipoOperacao
                .getMensagem()
                .replace("{user}", user.getLogin())
                .replace("{tipo}", tipoOperacao.name())
                .replace("{data}", formattedDate);

        novoHistorico.setDescricao(descricaoFormatada);
        return novoHistorico;
    }

    @Override
    public void salvar(HistoricoOperacoes historicoOperacao) {
        historicoOperacoesRepository.save(historicoOperacao);
    }

    @Override
    public List<HistoricoOperacoes> findByUsuario(Long idUsuario) {
        Usuario usuario = usuarioService.recuperarUsuarioPor(idUsuario);
        return historicoOperacoesRepository.findByUsuario(usuario);
    }
}
