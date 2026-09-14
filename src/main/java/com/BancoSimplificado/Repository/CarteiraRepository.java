package com.BancoSimplificado.Repository;

import com.BancoSimplificado.Entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, UUID> {
}
