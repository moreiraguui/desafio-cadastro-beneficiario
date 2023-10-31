package com.cadastrobeneficiario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cglib.core.Local;
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

    private String nome;
    private String telefone;
    private String dataNascimento;

    @Column(updatable = false)
    private LocalDate dataInclusão = LocalDate.now();
    private LocalDate dataAtualizacao;

    @OneToMany(targetEntity=Documento.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiarioId", referencedColumnName = "id")
    @JsonIgnoreProperties("beneficiario")
    private List<Documento> documentos = new ArrayList<>();

}
