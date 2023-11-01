package com.cadastrobeneficiario.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "beneficiario")
public class Beneficiario {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String dataNascimento;

    @Column(updatable = false)
    private LocalDate dataInclusao = LocalDate.now();
    private LocalDate dataAtualizacao;

    @OneToMany(targetEntity=Documento.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiarioId", referencedColumnName = "id")
    @JsonIgnoreProperties("beneficiario")
    private List<Documento> documentos = new ArrayList<>();

}
