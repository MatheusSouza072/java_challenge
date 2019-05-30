package br.com.codenation.desafio.exceptions;

public class CapitaoNaoInformadoException extends Exception {
    public CapitaoNaoInformadoException() {
        super("O capitão do time não foi informado");
    }
}
