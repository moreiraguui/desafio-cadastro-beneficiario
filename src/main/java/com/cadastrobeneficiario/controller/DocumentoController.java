package com.cadastrobeneficiario.controller;

import com.cadastrobeneficiario.model.Documento;
import com.cadastrobeneficiario.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    private DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @GetMapping("/{beneficiarioId}")
    public ResponseEntity<List<Documento>> getDocumentosByBeneficiarioId(@PathVariable UUID beneficiarioId) {
        Optional<List<Documento>> documentos = documentoService.getDocumentosByBeneficiarioId(beneficiarioId);

        return documentos.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
