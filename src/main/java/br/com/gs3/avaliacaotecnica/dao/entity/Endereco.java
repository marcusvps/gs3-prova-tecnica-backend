package br.com.gs3.avaliacaotecnica.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TAB_ENDERECO")
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 8, message = "CEP deve ter no minimo 8 caracteres")
    @NotNull(message = "CEP é um campo obrigatório.")
    @Column(nullable = false)
    private String cep;

    @Size(min = 5, message = "LOGRADOURO deve ter no minimo 5 caracteres")
    @NotNull(message = "LOGRADOURO é um campo obrigatório.")
    @Column(nullable = false)
    private String logradouro;

    @Size(min = 5, message = "BAIRRO deve ter no minimo 5 caracteres")
    @NotNull(message = "BAIRRO é um campo obrigatório.")
    @Column(nullable = false)
    private String bairro;

    @Size(min = 5, message = "CIDADE deve ter no minimo 5 caracteres")
    @NotNull(message = "CIDADE é um campo obrigatório.")
    @Column(nullable = false)
    private String cidade;

    @Size(min = 2, message = "UF deve ter no minimo 2 caracteres")
    @NotNull(message = "UF é um campo obrigatório.")
    @Column(nullable = false)
    private String uf;

    @Column()
    private String complemento;




}
