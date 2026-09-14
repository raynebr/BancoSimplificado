package com.BancoSimplificado.Exceptions;

public class CnpjJaCadastradoException extends RuntimeException{
    public CnpjJaCadastradoException(String mensagem){
        super(mensagem);
    }

    public CnpjJaCadastradoException(String mensagem, Throwable causa){
        super(mensagem,causa);
    }
}
