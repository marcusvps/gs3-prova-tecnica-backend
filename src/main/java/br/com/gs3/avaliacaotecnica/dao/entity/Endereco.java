package br.com.gs3.avaliacaotecnica.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TAB_ENDERECO")
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "CEP é um campo obrigatório.")
    @Column(nullable = false)
    private String cep;

    @NotNull(message = "LOGRADOURO é um campo obrigatório.")
    @Column(nullable = false)
    private String logradouro;

    @NotNull(message = "BAIRRO é um campo obrigatório.")
    @Column(nullable = false)
    private String bairro;

    @NotNull(message = "CIDADE é um campo obrigatório.")
    @Column(nullable = false)
    private String cidade;

    @NotNull(message = "UF é um campo obrigatório.")
    @Column(nullable = false)
    private String uf;

    @Column()
    private String complemento;




}
