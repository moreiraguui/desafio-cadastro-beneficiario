package com.cadastrobeneficiario.controller;

import com.cadastrobeneficiario.model.Beneficiario;
import com.cadastrobeneficiario.model.Documento;
import com.cadastrobeneficiario.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {
        private BeneficiarioService beneficiarioService;

    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @PostMapping
    ResponseEntity<Beneficiario> createBeneficiario(@RequestBody Beneficiario beneficiario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(beneficiarioService.createBeneficiario(beneficiario));
    }

    @GetMapping("/listar")
    ResponseEntity<List<Beneficiario>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(beneficiarioService.listAllBeneficiarios());
    }

    @PutMapping("/{id}")
    ResponseEntity<Beneficiario> updateBeneficiarioById(@PathVariable(value = "id") UUID id, @RequestBody Beneficiario beneficiario) {
        return ResponseEntity.status(HttpStatus.OK).body(beneficiarioService.updateBeneficiarioById(beneficiario, id));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteBeneficiarioById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(beneficiarioService.deleteBeneficiarioById(id));
    }
}
