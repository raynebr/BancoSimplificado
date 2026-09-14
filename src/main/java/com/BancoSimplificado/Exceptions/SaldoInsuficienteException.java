package com.BancoSimplificado.Exceptions;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String mensagem){
        super(mensagem);
    }
    public SaldoInsuficienteException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
