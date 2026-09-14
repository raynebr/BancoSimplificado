package com.BancoSimplificado.Exceptions;

public class CpfJaCadastradoException extends RuntimeException{
    public CpfJaCadastradoException(String mensagem){
        super(mensagem);
    }

    public CpfJaCadastradoException(String mensagem,Throwable causa){
        super(mensagem,causa);
    }
}
