package br.com.gs3.avaliacaotecnica.dao.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
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

    @NonNull
    private String email;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
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
