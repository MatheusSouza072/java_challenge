package br.com.codenation.desafio;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.service.impl.MeuTimeInterfaceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) throws IdentificadorUtilizadoException, TimeNaoEncontradoException, JogadorNaoEncontradoException, CapitaoNaoInformadoException {
        MeuTimeInterfaceImpl meuTimeInterface = new MeuTimeInterfaceImpl();

        meuTimeInterface.incluirTime(1L, "nome1", LocalDate.now(), "Uniforme Cor", "uniforme sec");
        meuTimeInterface.incluirTime(2L, "nome2", LocalDate.now(), "Uniforme Cor", "uniforme sec");
        meuTimeInterface.incluirTime(3L, "nome3", LocalDate.now(), "Uniforme Cor", "uniforme sec");
        meuTimeInterface.incluirTime(4L, "nome4", LocalDate.now(), "Uniforme Cor", "uniforme sec");
        meuTimeInterface.incluirTime(5L, "nome5", LocalDate.now(), "Uniforme Cor", "uniforme sec");
        meuTimeInterface.incluirTime(6L, "nome6", LocalDate.now(), "Uniforme Cor", "uniforme sec");

        meuTimeInterface.incluirJogador(1L, 6L, "nome1", LocalDate.of(2012, Month.JANUARY, 1), 5, BigDecimal.valueOf(20000.000));
        meuTimeInterface.incluirJogador(2L, 6L, "nome2", LocalDate.of(2012, Month.JANUARY, 1), 6, BigDecimal.valueOf(30000.000));
        meuTimeInterface.incluirJogador(3L, 6L, "nome3", LocalDate.of(1980, Month.JANUARY, 1), 10, BigDecimal.valueOf(100000.000));
        meuTimeInterface.incluirJogador(4L, 6L, "nome4", LocalDate.of(1980, Month.JANUARY, 1), 8, BigDecimal.valueOf(110000.000));
        meuTimeInterface.incluirJogador(5L, 6L, "Mauricio", LocalDate.of(1992, Month.JANUARY, 26), 4, BigDecimal.valueOf(60000.000));

//        System.out.println(meuTimeInterface.buscarJogadoresDoTime(6L));
//        System.out.println(meuTimeInterface.buscarJogadorMaisVelho(6L));
//        System.out.println(meuTimeInterface.buscarMelhorJogadorDoTime(6L));
//        System.out.println(meuTimeInterface.buscarTopJogadores(30));
//        System.out.println(meuTimeInterface.buscarSalarioDoJogador(1L));
//        System.out.println(meuTimeInterface.buscarJogadorMaiorSalario(5L));
//        System.out.println(meuTimeInterface.buscarNomeTime(6L));
//        System.out.println(meuTimeInterface.buscarNomeJogador(1L));
//        meuTimeInterface.definirCapitao(1L);
//        System.out.println(meuTimeInterface.buscarCapitaoDoTime(6L));
        System.out.println(meuTimeInterface.buscarCorCamisaTimeDeFora(6L, 5L));

    }
}
