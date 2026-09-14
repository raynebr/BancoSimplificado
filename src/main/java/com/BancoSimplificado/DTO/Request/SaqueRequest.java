package com.BancoSimplificado.DTO.Request;

import java.math.BigDecimal;

public record SaqueRequest(
        String numeroConta,
        BigDecimal valor
) {
}
