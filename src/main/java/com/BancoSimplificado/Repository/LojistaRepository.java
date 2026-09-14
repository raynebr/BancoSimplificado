package com.BancoSimplificado.Repository;

import com.BancoSimplificado.Entity.Lojista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LojistaRepository extends JpaRepository<Lojista, UUID> {

    Optional<Lojista> findByCnpj(String cnpj);
}