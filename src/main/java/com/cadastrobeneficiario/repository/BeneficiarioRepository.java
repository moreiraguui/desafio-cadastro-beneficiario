package com.cadastrobeneficiario.repository;

import com.cadastrobeneficiario.model.Beneficiario;
import org.springframework.data.repository.CrudRepository;

public interface BeneficiarioRepository extends CrudRepository<Beneficiario, Long> {
}
