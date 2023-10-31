package com.cadastrobeneficiario.controller;

import com.cadastrobeneficiario.model.Beneficiario;
import com.cadastrobeneficiario.service.BeneficiarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {
    private BeneficiarioService beneficiarioService;

    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @PostMapping
    ResponseEntity<Beneficiario> createBeneficiario(@Valid @RequestBody Beneficiario beneficiario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(beneficiarioService.createBeneficiario(beneficiario));
    }

    @GetMapping("/listar")
    ResponseEntity<List<Beneficiario>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(beneficiarioService.listAllBeneficiarios());
    }

    @PutMapping("/{id}")
    ResponseEntity<Beneficiario> updateBeneficiarioById(@Valid @PathVariable(value = "id") UUID id, @RequestBody Beneficiario beneficiario) {
        return ResponseEntity.status(HttpStatus.OK).body(beneficiarioService.updateBeneficiarioById(beneficiario, id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteBeneficiarioById(@Valid @PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(beneficiarioService.deleteBeneficiarioById(id));
    }
}
