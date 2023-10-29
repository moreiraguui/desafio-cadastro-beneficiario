package com.cadastrobeneficiario.service;

import com.cadastrobeneficiario.model.Beneficiario;
import com.cadastrobeneficiario.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public Beneficiario create(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    public List<Beneficiario> listar(){
        return (List<Beneficiario>) beneficiarioRepository.findAll();
    }
}
