package com.BancoSimplificado.Exceptions;

public class ValorInvalidoException extends RuntimeException{
    public ValorInvalidoException(String mensagem){
        super(mensagem);
    }
    public ValorInvalidoException(String mensagem,Throwable causa){
        super(mensagem, causa);
    }
}
