package com.cadastrobeneficiario;

import com.cadastrobeneficiario.model.Beneficiario;
import com.cadastrobeneficiario.model.Documento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CadastroBeneficiarioApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateBeneficiarioSucess() {

        var documento1 = new Documento(UUID.randomUUID(), "RG", "11111111-11", LocalDate.now(), null, new Beneficiario());
        var documento2 = new Documento(UUID.randomUUID(), "CPF", "11111111.11-11", LocalDate.now(), null, new Beneficiario());
        List<Documento> documentosList = List.of(documento1, documento2);
        var beneficiario = new Beneficiario(UUID.randomUUID(), "Guilherme Moreira", "(11) 111111-1111",
                "01-01-0001", LocalDate.now(), null, documentosList);
    webTestClient
            .post()
            .uri("/beneficiarios")
            .bodyValue(beneficiario)
            .exchange()
            .expectStatus().isCreated()
            .expectBody()
            .jsonPath("nome").isEqualTo(beneficiario.getNome())
            .jsonPath("telefone").isEqualTo(beneficiario.getTelefone())
            .jsonPath("dataNascimento").isEqualTo(beneficiario.getDataNascimento())
            .jsonPath("dataInclusao").isNotEmpty()
            .jsonPath("dataAtualizacao").isEmpty()
            .jsonPath("$.documentos").exists()
            .jsonPath("$.documentos").isArray()
            .jsonPath("$.documentos").isNotEmpty()
            .jsonPath("$.documentos.length()").isEqualTo(2);
    }
    @Test
    void testCreateBeneficiarioFailure() {

        webTestClient
        .post()
                .uri("/beneficiarios")
                .bodyValue(new Beneficiario(UUID.randomUUID(), "", " ", " ", null, null, null))
                .exchange()
                .expectStatus().isBadRequest();
    }


}
