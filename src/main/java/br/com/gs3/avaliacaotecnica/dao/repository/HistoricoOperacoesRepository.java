package br.com.gs3.avaliacaotecnica.dao.repository;

import br.com.gs3.avaliacaotecnica.dao.entity.HistoricoOperacoes;
import br.com.gs3.avaliacaotecnica.dao.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoOperacoesRepository extends JpaRepository<HistoricoOperacoes,Long> {

    List<HistoricoOperacoes> findByUsuario(Usuario usuario);
}
