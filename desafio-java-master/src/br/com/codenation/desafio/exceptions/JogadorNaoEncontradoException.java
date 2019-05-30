package br.com.codenation.desafio.exceptions;

public class JogadorNaoEncontradoException extends Exception {
    public JogadorNaoEncontradoException() {
        super("O jogador não foi encontrado");
    }
}
