package com.BancoSimplificado.DTO.Request;

public record LojistaRequest(
                             String email,
                             String senha,
                             String cnpj,
                             String nomeLoja
) {
}
