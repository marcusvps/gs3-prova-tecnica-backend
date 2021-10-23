package br.com.gs3.avaliacaotecnica.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="TAB_HISTORICO_OPERACOES")
@Getter
@Setter
public class HistoricoOperacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private LocalDate dataOperacao;

    @Enumerated
    @Column
    private TipoOperacao tipoOperacao;

    @ManyToOne
    @JoinColumn(name = "usuario_login")
    private Usuario usuario;

}
