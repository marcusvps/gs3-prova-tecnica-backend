package br.com.gs3.avaliacaotecnica.dao.entity;

import br.com.gs3.avaliacaotecnica.enumerador.TipoOperacao;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime dataOperacao;

    @Column
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoOperacao tipoOperacao;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "usuario_login")
    private Usuario usuario;

}
