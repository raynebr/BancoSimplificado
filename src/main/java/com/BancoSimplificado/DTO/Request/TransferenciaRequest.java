package com.BancoSimplificado.DTO.Request;

import java.math.BigDecimal;

public record TransferenciaRequest(
        String numeroContaOrigem,
        String numeroContaDestino,
        BigDecimal valor
) {
}
