package com.BancoSimplificado.Exceptions;

public class ContasIguaisException extends RuntimeException{
    public ContasIguaisException(String mensagem){
        super(mensagem);
    }

    public ContasIguaisException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
