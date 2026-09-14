package com.BancoSimplificado.Repository;

import com.BancoSimplificado.Entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, UUID> {

    boolean existsByNumeroConta(String numeroConta);
    Optional<Carteira> findByNumeroConta(String numeroConta);
}