package com.cadastrobeneficiario.service;

import com.cadastrobeneficiario.model.Beneficiario;
import com.cadastrobeneficiario.model.Documento;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;


public interface BeneficiarioService {

    Beneficiario createBeneficiario(Beneficiario beneficiario);

    List<Beneficiario> listAllBeneficiarios();

    Beneficiario updateBeneficiarioById(Beneficiario beneficiario, UUID id);

    Object deleteBeneficiarioById(UUID id);
}
