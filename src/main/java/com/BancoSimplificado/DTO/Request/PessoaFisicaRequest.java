package com.BancoSimplificado.DTO.Request;

public record PessoaFisicaRequest(
        String nome,
        String email,
        String senha,
        String cpf
) {
}
