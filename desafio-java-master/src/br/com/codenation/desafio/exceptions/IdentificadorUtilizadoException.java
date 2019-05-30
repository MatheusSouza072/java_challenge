package br.com.codenation.desafio.exceptions;

public class IdentificadorUtilizadoException extends Exception {

    public IdentificadorUtilizadoException() {
        super("O Identificador já Está Sendo Utilizado!");
    }
}
