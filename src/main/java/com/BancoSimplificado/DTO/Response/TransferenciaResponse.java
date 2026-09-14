package com.BancoSimplificado.DTO.Response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransferenciaResponse(
        BigDecimal valor,
        String numeroContaOrigem,
        String numeroContaDestino,
        String titularDestino,
        BigDecimal saldoAtual,
        LocalDateTime data
) {
}
