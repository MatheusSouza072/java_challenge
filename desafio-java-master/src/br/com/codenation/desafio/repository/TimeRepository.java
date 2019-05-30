package br.com.codenation.desafio.repository;

import br.com.codenation.desafio.entity.Jogador;
import br.com.codenation.desafio.entity.Time;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;

import java.util.ArrayList;
import java.util.List;

public class TimeRepository {

    public void save(Time time) {
        Time.timeList.add(time);
    }

    public List<Long> findAll() {
        List<Long> idTimeList = new ArrayList<>();

        for (Time time : Time.timeList) {
            idTimeList.add(time.getIdTime());
        }

        return idTimeList;
    }

    public String findName(Long idTime) {
        List<Time> timeList = Time.timeList;
        String nameTime = "";

        for (Time time : timeList) {
            if (time.getIdTime().equals(idTime)) {
                nameTime = time.getNome();
            }
        }
        return nameTime;
    }

    public Long findCaptain(Long idTime) throws CapitaoNaoInformadoException {
        List<Time> timeList = Time.timeList;
        Long captain = 0L;

        for (Time time : timeList) {
            if (time.getIdTime().equals(idTime)) {
                captain = time.getCapitao();
            }
        }

        if (captain == null) {
            throw new CapitaoNaoInformadoException();
        }
        return captain;
    }

    public void toDefineCaptain(Long idJogador) {
        List<Jogador> jogadorList = Jogador.jogadorList;

        for (Jogador jogador : jogadorList) {
            if (jogador.getIdJogador().equals(idJogador)) {
                Time.timeList.get(jogador.getIdTime().intValue() - 1).setCapitao(jogador.getIdJogador());
            }
        }
    }

    public String buscarCorCamisaTimeDeFora(Long idTimeCasa, Long idTimeFora) {
        List<Time> timeList = Time.timeList;
        String corCamisaPrincipalTimeDecasa = "";
        String corCamisaPrincipalTimeDeFora = "";
        String corCamisaSecundariaTimeDeFora = "";

        for (Time time : timeList) {
            if (time.getIdTime().equals(idTimeCasa)) {
                corCamisaPrincipalTimeDecasa = time.getCorUniformePrincipal();
            } else if (time.getIdTime().equals(idTimeFora)) {
                corCamisaPrincipalTimeDeFora = time.getCorUniformePrincipal();
                corCamisaSecundariaTimeDeFora = time.getCorUniformeSecundario();
            }
        }

        if (corCamisaPrincipalTimeDecasa.equals(corCamisaPrincipalTimeDeFora)) {
            return corCamisaSecundariaTimeDeFora;
        } else {
            return corCamisaPrincipalTimeDeFora;
        }
    }
}
