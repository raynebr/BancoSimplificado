package com.BancoSimplificado.Handler;

import java.time.LocalDateTime;

public record ErroResposta(
        int status,
        String titulo,
        String mensagem,
        LocalDateTime data
) {

}
