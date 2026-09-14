package com.BancoSimplificado.DTO.Request;

import java.math.BigDecimal;

public record DepositoRequest(
        String numeroConta,
        BigDecimal valor
) {
}
