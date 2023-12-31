package com.cadastrobeneficiario.repository;

import com.cadastrobeneficiario.model.Beneficiario;
import com.cadastrobeneficiario.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, UUID> {



}
