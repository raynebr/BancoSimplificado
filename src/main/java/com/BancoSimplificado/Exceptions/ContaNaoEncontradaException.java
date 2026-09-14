package com.BancoSimplificado.Exceptions;

public class ContaNaoEncontradaException extends RuntimeException{
    public ContaNaoEncontradaException(String mensagem){
        super(mensagem);
    }
    public ContaNaoEncontradaException(String mensagem, Throwable causa){
        super(mensagem, causa);
    }
}
