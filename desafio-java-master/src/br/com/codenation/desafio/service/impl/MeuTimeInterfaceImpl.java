package br.com.codenation.desafio.service.impl;

import br.com.codenation.desafio.entity.Jogador;
import br.com.codenation.desafio.entity.Time;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.repository.JogadorRepository;
import br.com.codenation.desafio.repository.TimeRepository;
import br.com.codenation.desafio.service.MeuTimeInterface;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class MeuTimeInterfaceImpl implements MeuTimeInterface {

    private final TimeRepository timeRepository;
    private final JogadorRepository jogadorRepository;

    public MeuTimeInterfaceImpl() {
        timeRepository = new TimeRepository();
        jogadorRepository = new JogadorRepository();
    }

    @Override
    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
                            String corUniformeSecundario) throws IdentificadorUtilizadoException {

        Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
        verifyIfIdETimexistis(time);
        timeRepository.save(time);
    }

    @Override
    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) throws TimeNaoEncontradoException, IdentificadorUtilizadoException {
        Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
        verifyIfTimeExistis(jogador.getIdTime());
        verifyIfIdEJogadorxistis(jogador);
        jogadorRepository.save(jogador);
    }

    @Override
    public void definirCapitao(Long idJogador) throws JogadorNaoEncontradoException {
        verifyIfJogadorExistis(idJogador);
        timeRepository.toDefineCaptain(idJogador);
    }

    @Override
    public Long buscarCapitaoDoTime(Long idTime) throws CapitaoNaoInformadoException, TimeNaoEncontradoException {
        verifyIfTimeExistis(idTime);
        return timeRepository.findCaptain(idTime);
    }

    @Override
    public String buscarNomeJogador(Long idJogador) throws JogadorNaoEncontradoException {
        verifyIfJogadorExistis(idJogador);
        return jogadorRepository.findName(idJogador);
    }

    @Override
    public String buscarNomeTime(Long idTime) throws TimeNaoEncontradoException {
        verifyIfTimeExistis(idTime);
        return timeRepository.findName(idTime);
    }

    @Override
    public Long buscarJogadorMaiorSalario(Long idTime) throws TimeNaoEncontradoException {
        verifyIfTimeExistis(idTime);
        return jogadorRepository.findHigherSalaryJogadorByTime(idTime);
    }

    @Override
    public BigDecimal buscarSalarioDoJogador(Long idJogador) throws JogadorNaoEncontradoException {
        verifyIfJogadorExistis(idJogador);
        return jogadorRepository.findJogadorSalary(idJogador);
    }

    @Override
    public List<Long> buscarJogadoresDoTime(Long idTime) throws TimeNaoEncontradoException {
        verifyIfTimeExistis(idTime);
        return jogadorRepository.findByIdTime(idTime);
    }

    @Override
    public Long buscarMelhorJogadorDoTime(Long idTime) throws TimeNaoEncontradoException {
        verifyIfTimeExistis(idTime);
        return jogadorRepository.findTheBestByTime(idTime);
    }

    @Override
    public Long buscarJogadorMaisVelho(Long idTime) throws TimeNaoEncontradoException {
        verifyIfTimeExistis(idTime);
        return jogadorRepository.findOlderByIdTime(idTime);
    }

    @Override
    public List<Long> buscarTimes() {
        return timeRepository.findAll();
    }

    @Override
    public List<Long> buscarTopJogadores(Integer top) {
        return jogadorRepository.findTopJogadores(top);
    }

    @Override
    public String buscarCorCamisaTimeDeFora(Long idTimeCasa, Long idTimeFora) throws TimeNaoEncontradoException {
        verifyIfTimeExistis(idTimeCasa);
        verifyIfTimeExistis(idTimeFora);
        return timeRepository.buscarCorCamisaTimeDeFora(idTimeCasa, idTimeFora);
    }


    private void verifyIfJogadorExistis(Long idJogador) throws JogadorNaoEncontradoException {
        List<Long> idJogadorList = jogadorRepository.findAll();
        if (!idJogadorList.isEmpty()) {
            iterationIdJogadorList(idJogador, idJogadorList);
        } else {
            throw new JogadorNaoEncontradoException();
        }
    }

    private void iterationIdJogadorList(Long idJogador, List<Long> idJogadorList) throws JogadorNaoEncontradoException {
        int contador = 0;

        for (Long idJogadorr : idJogadorList) {
            ++contador;

            if (validIfIdJogadorExistis(idJogador, idJogadorr)) {
                break;
            }

            if (contador >= idJogadorList.size()) {
                throw new JogadorNaoEncontradoException();
            }
        }
    }

    private boolean validIfIdJogadorExistis(Long idJogadorr, Long idJogador) {
        if (idJogador.equals(idJogadorr)) {
            return true;
        }
        return false;
    }


    private void verifyIfIdETimexistis(Time time) throws IdentificadorUtilizadoException {
        for (Time contador : Time.timeList) {
            iterationTimeList(time, contador);
        }
    }

    private void iterationTimeList(Time time, Time timeCont) throws IdentificadorUtilizadoException {
        if (timeCont.getIdTime().equals(time.getIdTime())) {
            throw new IdentificadorUtilizadoException();
        }
    }


    private void verifyIfTimeExistis(Long idTimeJogador) throws TimeNaoEncontradoException {
        List<Long> idTimeList = buscarTimes();
        if (!idTimeList.isEmpty()) {
            iterationIdTimeList(idTimeJogador, idTimeList);
        } else {
            throw new TimeNaoEncontradoException();
        }
    }

    private void iterationIdTimeList(Long idTimeJogador, List<Long> idTimeList) throws TimeNaoEncontradoException {
        int contador = 0;

        for (Long idTime : idTimeList) {
            ++contador;

            if (validIfIdTimeExistis(idTimeJogador, idTime)) {
                break;
            }

            if (contador >= idTimeList.size()) {
                throw new TimeNaoEncontradoException();
            }
        }
    }

    private boolean validIfIdTimeExistis(Long idTimeJogador, Long idTime) {
        if (idTime.equals(idTimeJogador)) {
            return true;
        }
        return false;
    }

    private void verifyIfIdEJogadorxistis(Jogador jogador) throws IdentificadorUtilizadoException {
        for (Jogador contador : Jogador.jogadorList) {
            iterationJogadorList(jogador, contador);
        }
    }

    private void iterationJogadorList(Jogador jogador, Jogador contador) throws IdentificadorUtilizadoException {
        if (contador.getIdJogador().equals(jogador.getIdJogador())) {
            throw new IdentificadorUtilizadoException();
        }
    }
}
