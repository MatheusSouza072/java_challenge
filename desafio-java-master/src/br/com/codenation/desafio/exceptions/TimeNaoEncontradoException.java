package br.com.codenation.desafio.exceptions;

public class TimeNaoEncontradoException extends Exception {
    public TimeNaoEncontradoException() {
        super("O time não foi encontrado");
    }
}
