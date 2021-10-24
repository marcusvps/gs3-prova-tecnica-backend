package br.com.gs3.avaliacaotecnica.dao.entity;

import br.com.gs3.avaliacaotecnica.enumerador.TipoPerfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "login", nullable = false)
    private String login;

    @JsonIgnore
    @Column(name = "senha", nullable = false)
    private String senha;

    @JsonManagedReference
    @OneToMany(mappedBy ="usuario", fetch = FetchType.LAZY)
    private List<HistoricoOperacoes> historicoOperacoes;

    @Enumerated(EnumType.STRING)
    private TipoPerfil tipoPerfil;


}
