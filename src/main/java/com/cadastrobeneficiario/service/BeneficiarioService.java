package com.cadastrobeneficiario.service;

import com.cadastrobeneficiario.model.Beneficiario;

import java.util.List;


public interface BeneficiarioService {

    Beneficiario create(Beneficiario beneficiario);

    List<Beneficiario> listar();

}
