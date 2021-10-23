package br.com.gs3.avaliacaotecnica.dao.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name="TAB_EMAIL")
@Getter
@Setter
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 10, message = "EMAIL deve ter no minimo 8 caracteres")
    @NotNull(message = "O email é um campo obrigatório.")
    @javax.validation.constraints.Email(message = "Informe um e-mail válido")
    private String email;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private Cliente cliente;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return email.equals(email1.email) && cliente.equals(email1.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, cliente);
    }
}
