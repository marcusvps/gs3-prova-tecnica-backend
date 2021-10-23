package br.com.gs3.avaliacaotecnica.dao.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Column(nullable = false)
    private String cpf;

    @NotNull(message = "Endereço é obrigatório.")
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Size(min = 1, message = "Pelo menos um e-mail deve ser informado.")
    @OneToMany(mappedBy = "cliente")
    private Set<Email> emails;

    @Size(min = 1, message = "Pelo menos um telefone deve ser informado.")
    @OneToMany(mappedBy = "cliente")
    private Set<Telefone> telefones;






}






