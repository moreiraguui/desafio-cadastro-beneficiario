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
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "documento")
public class Documento {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @NotBlank
    private String tipoDocumento;

    @NotBlank
    private String descricao;

    private LocalDate dataInclusao = LocalDate.now();
    private LocalDate dataAtualizacao;

    @ManyToOne(targetEntity = Beneficiario.class)
    @JoinColumn(name = "beneficiarioId")
    @JsonIgnoreProperties("documentos")
    private Beneficiario beneficiario;

}
