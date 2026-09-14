package com.BancoSimplificado.DTO.Response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DepositoResponse(
        BigDecimal valor,
        String numeroContaDestino,
        String titularDestino,
        BigDecimal saldoAtual,
        LocalDateTime data
) {
}
