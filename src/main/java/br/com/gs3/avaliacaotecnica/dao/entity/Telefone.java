package br.com.gs3.avaliacaotecnica.dao.entity;

import br.com.gs3.avaliacaotecnica.enumerador.TipoTelefone;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name="TAB_TELEFONE")
@Getter
@Setter
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "TIPO DE TELEFONE é um campo obrigatório.")
    private TipoTelefone tipoTelefone;

    @NotNull(message = "NUMERO DE TELEFONE é um campo obrigatório.")
    @Column
    private Long numero;



    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private Cliente cliente;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return tipoTelefone == telefone.tipoTelefone && Objects.equals(numero, telefone.numero) && Objects.equals(cliente, telefone.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoTelefone, numero, cliente);
    }
}
