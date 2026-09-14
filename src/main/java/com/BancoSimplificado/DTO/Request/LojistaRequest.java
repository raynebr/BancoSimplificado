package com.BancoSimplificado.DTO.Request;

public record LojistaRequest(
                             String nome,
                             String email,
                             String senha,
                             String cnpj,
                             String nomeLoja
) {
}
