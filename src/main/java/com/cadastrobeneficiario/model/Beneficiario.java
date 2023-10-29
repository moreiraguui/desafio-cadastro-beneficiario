package com.cadastrobeneficiario.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cglib.core.Local;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "BENEFICIARIOS")
@Entity
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String dataNascimento;
    private LocalDate dataInclusão = LocalDate.now();
    private LocalDate dataAtualizacao;

    @OneToMany
    private List<Documento> documentos = new ArrayList<>();

}
