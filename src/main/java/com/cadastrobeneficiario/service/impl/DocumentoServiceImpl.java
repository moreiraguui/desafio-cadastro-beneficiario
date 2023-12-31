package com.cadastrobeneficiario.service.impl;

import com.cadastrobeneficiario.model.Documento;
import com.cadastrobeneficiario.repository.DocumentoRepository;
import com.cadastrobeneficiario.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentoServiceImpl implements DocumentoService {


    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public Optional<List<Documento>> getDocumentosByBeneficiarioId(UUID beneficiarioId) {
        return documentoRepository.findByBeneficiarioId(beneficiarioId);
    }
}
