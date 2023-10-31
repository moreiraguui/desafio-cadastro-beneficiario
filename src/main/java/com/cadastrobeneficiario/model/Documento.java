package com.cadastrobeneficiario.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.relational.core.mapping.Table;


import java.rmi.server.UID;
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

    private String tipoDocumento;

    private String descricao;

    private LocalDate dataInclusao = LocalDate.now();
    private LocalDate dataAtualizacao;

    @ManyToOne
    @JsonIgnoreProperties("documento")
    private Beneficiario beneficiario;

}
