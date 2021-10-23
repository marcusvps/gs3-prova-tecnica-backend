package br.com.gs3.avaliacaotecnica.dao.repository;

import br.com.gs3.avaliacaotecnica.dao.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {}
