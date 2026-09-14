package com.BancoSimplificado.DTO.Response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SaqueResponse(
        BigDecimal valor,
        String numeroConta,
        BigDecimal saldoAtual,
        LocalDateTime data
) {
}
