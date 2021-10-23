package br.com.gs3.avaliacaotecnica.dao.entity;

import br.com.gs3.avaliacaotecnica.annotation.Telefone;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="TAB_CLIENTE")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 3, max = 100, message = "O nome do cliente deve ter entre 3 e 100 caracteres")
    @NotNull(message = "Nome é um campo obrigatório.")
    @Column(nullable = false,length = 100)
    private String nome;


    @NotNull(message = "CPF é um campo obrigatório.")
    @Column(nullable = false,unique = true)
    private String cpf;

    @Valid
    @NotNull(message = "Endereço é obrigatório.")
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Valid
    @NotNull(message = "Ao menos um email deve ser informado.")
    @Size(min = 1, message = "Ao menos um email deve ser informado.")
    @Size(min = 1, message = "Pelo menos um e-mail deve ser informado.")
    @OneToMany(mappedBy = "cliente" ,cascade = CascadeType.MERGE)
    @JsonManagedReference
    private Set<Email> emails;

    @Telefone
    @Valid
    @NotNull(message = "Ao menos um telefone deve ser informado.")
    @Size(min = 1, message = "Ao menos um telefone deve ser informado.")
    @Size(min = 1, message = "Pelo menos um telefone deve ser informado.")
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE)
    @JsonManagedReference
    private Set<br.com.gs3.avaliacaotecnica.dao.entity.Telefone> telefones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}






