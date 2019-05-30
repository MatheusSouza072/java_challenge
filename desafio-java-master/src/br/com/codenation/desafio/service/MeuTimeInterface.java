package br.com.codenation.desafio.service;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface MeuTimeInterface {

    void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) throws IdentificadorUtilizadoException;

    void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) throws TimeNaoEncontradoException, IdentificadorUtilizadoException;

    void definirCapitao(Long idJogador) throws JogadorNaoEncontradoException;

    Long buscarCapitaoDoTime(Long idTime) throws CapitaoNaoInformadoException, TimeNaoEncontradoException;

    String buscarNomeJogador(Long idJogador) throws JogadorNaoEncontradoException;

    String buscarNomeTime(Long idTime) throws TimeNaoEncontradoException;

    Long buscarJogadorMaiorSalario(Long idTime) throws TimeNaoEncontradoException;

    BigDecimal buscarSalarioDoJogador(Long idJogador) throws JogadorNaoEncontradoException;

    List<Long> buscarJogadoresDoTime(Long idTime) throws TimeNaoEncontradoException;

    Long buscarMelhorJogadorDoTime(Long idTime) throws TimeNaoEncontradoException;

    Long buscarJogadorMaisVelho(Long idTime) throws TimeNaoEncontradoException;

    List<Long> buscarTimes();

    List<Long> buscarTopJogadores(Integer top);

    String buscarCorCamisaTimeDeFora(Long idTimeCasa, Long idTimeFora) throws TimeNaoEncontradoException;
}
