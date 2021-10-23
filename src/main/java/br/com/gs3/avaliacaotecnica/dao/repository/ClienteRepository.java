package br.com.gs3.avaliacaotecnica.dao.repository;

import br.com.gs3.avaliacaotecnica.dao.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);
}
