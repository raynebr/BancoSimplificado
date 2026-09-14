package com.BancoSimplificado.Handler;

import com.BancoSimplificado.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ContaNaoEncontradaException.class)
    public ResponseEntity<ErroResposta> tratarContaNaoEncontrada(
            ContaNaoEncontradaException ex) {

        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Conta não encontrada",
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(erro);
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public  ResponseEntity<ErroResposta> tratarSaldoInsuficiente(SaldoInsuficienteException ex){
      ErroResposta erro = new ErroResposta(
              HttpStatus.UNPROCESSABLE_ENTITY.value(),
              "saldo insuficiente",
              ex.getMessage(),
              LocalDateTime.now()
      );
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }

    @ExceptionHandler(ValorInvalidoException.class)
    public ResponseEntity<ErroResposta> tratarValorInvalido(ValorInvalidoException ex) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "valor e invalido",
                ex.getMessage(),
                LocalDateTime.now()

        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }

    @ExceptionHandler(ContasIguaisException.class)
    public ResponseEntity<ErroResposta> tratarContasIguais(ContasIguaisException ex){
        ErroResposta erro = new ErroResposta(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Contas iguais",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }
    @ExceptionHandler(EmailJaCadastradoException.class)
    public  ResponseEntity<ErroResposta> tratarEmailJaCdastrado(EmailJaCadastradoException ex){
        ErroResposta erro = new ErroResposta(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Email ja Cadastrado",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }

    @ExceptionHandler(CpfJaCadastradoException.class)
    public ResponseEntity<ErroResposta> tratarCpfEmUso(CpfJaCadastradoException ex){
        ErroResposta erro = new ErroResposta(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Cpf em Uso",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }
    @ExceptionHandler(CnpjJaCadastradoException.class)
    public ResponseEntity<ErroResposta> tratarCnpjEmUso(CnpjJaCadastradoException ex){
        ErroResposta erro = new ErroResposta(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Cnpj em Uso",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }
}