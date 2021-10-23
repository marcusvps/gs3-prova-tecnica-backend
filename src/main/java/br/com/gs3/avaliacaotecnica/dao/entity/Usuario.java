package br.com.gs3.avaliacaotecnica.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="TAB_USUARIO")
@Getter
@Setter
public class Usuario {

    @Id
    @Column(name = "login", nullable = false)
    private String login;

    @Column
    private String senha;

    @OneToMany(mappedBy ="usuario")
    private List<HistoricoOperacoes> historicoOperacoes;

    @Enumerated
    @Column
    private TipoPerfil tipoPerfil;

}
