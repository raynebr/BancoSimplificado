package com.BancoSimplificado.Repository;


import com.BancoSimplificado.Entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
    List<Transacao> findByOrigemIdOrDestinoId(UUID origemId,UUID destinoId);
}
