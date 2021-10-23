package br.com.gs3.avaliacaotecnica.dao.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
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

    @Enumerated
    @Column
    private TipoTelefone tipoTelefone;

    @NonNull
    @Column
    private Long numero;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
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
