package com.cadastrobeneficiario.controller;

import com.cadastrobeneficiario.model.Beneficiario;
import com.cadastrobeneficiario.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @PostMapping
    Beneficiario create(Beneficiario beneficiario) {
        return beneficiarioService.create(beneficiario);
    }

    @GetMapping("/listar")
    List<Beneficiario> listAll() {
        return beneficiarioService.listar();
    }
}
