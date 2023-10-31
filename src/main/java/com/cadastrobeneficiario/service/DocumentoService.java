package com.cadastrobeneficiario.service;

import com.cadastrobeneficiario.model.Documento;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DocumentoService {
    Optional<List<Documento>> getDocumentosByBeneficiarioId(UUID beneficiarioId);
}
