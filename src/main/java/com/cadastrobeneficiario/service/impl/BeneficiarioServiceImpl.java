package com.cadastrobeneficiario.service.impl;

import com.cadastrobeneficiario.model.Beneficiario;
import com.cadastrobeneficiario.model.Documento;
import com.cadastrobeneficiario.repository.BeneficiarioRepository;
import com.cadastrobeneficiario.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public Beneficiario createBeneficiario(Beneficiario beneficiario) {
        beneficiario.setDataInclusão(LocalDate.now());
        return beneficiarioRepository.save(beneficiario);
    }

    public List<Beneficiario> listAllBeneficiarios() {
        return beneficiarioRepository.findAll();
    }

    public Beneficiario updateBeneficiarioById(Beneficiario beneficiario, UUID id) {
        List<Documento> documentoList = beneficiario.getDocumentos();
        documentoList.forEach(doc -> {
            doc.setDataAtualizacao(LocalDate.now());
        });
        return beneficiarioRepository.findById(id)
                .map(beneficiarioUpdate -> {
                    beneficiarioUpdate.setNome(beneficiario.getNome());
                    beneficiarioUpdate.setTelefone(beneficiario.getTelefone());
                    beneficiarioUpdate.setDataNascimento(beneficiario.getDataNascimento());
                    beneficiarioUpdate.setDataAtualizacao(LocalDate.now());
                    beneficiarioUpdate.setDocumentos(beneficiario.getDocumentos());
                    Beneficiario update = beneficiarioRepository.save(beneficiarioUpdate);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build()).getBody();
    }

    public Object deleteBeneficiarioById(UUID id) {
        return beneficiarioRepository.findById(id)
                .map(beneficiarioDelete -> {
                    beneficiarioRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}