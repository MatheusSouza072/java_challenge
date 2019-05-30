package br.com.codenation.desafio.repository;

import br.com.codenation.desafio.entity.Jogador;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JogadorRepository {

    public void save(Jogador jogador) {
        Jogador.jogadorList.add(jogador);
    }

    public List<Long> findByIdTime(Long idTime) {
        List<Long> idJogadorList = new ArrayList<>();

        for (Jogador jogador : Jogador.jogadorList) {
            if (idTime.equals(jogador.getIdTime())) {
                idJogadorList.add(jogador.getIdJogador());
            }
        }

        return idJogadorList;
    }

    public Long findOlderByIdTime(Long idTime) {
        List<Jogador> jogadorList = new ArrayList<>();
        LocalDate localDate = LocalDate.of(999999999, Month.JANUARY, 1);
        Long idJogadorOlder = 0L;

        for (Jogador jogador : Jogador.jogadorList) {
            if (idTime.equals(jogador.getIdTime())) {
                jogadorList.add(jogador);
            }
        }

        for (Jogador jogador : jogadorList) {
            if (jogador.getDataNascimento().isBefore(localDate)) {
                localDate = jogador.getDataNascimento();
                idJogadorOlder = jogador.getIdJogador();
            } else if (jogador.getDataNascimento().equals(localDate) && jogador.getIdJogador() < idJogadorOlder) {
                localDate = jogador.getDataNascimento();
                idJogadorOlder = jogador.getIdJogador();
            }
        }

        return idJogadorOlder;
    }

    public Long findTheBestByTime(Long idTime) {
        List<Jogador> jogadorList = new ArrayList<>();
        Integer level = 1;
        Long idTheBestJogador = 0L;

        for (Jogador jogador : Jogador.jogadorList) {
            if (idTime.equals(jogador.getIdTime())) {
                jogadorList.add(jogador);
            }
        }

        for (Jogador jogador : jogadorList) {
            if (jogador.getNivelHabilidade() > level) {
                level = jogador.getNivelHabilidade();
                idTheBestJogador = jogador.getIdJogador();
            }
        }
        return idTheBestJogador;
    }

    public List<Long> findTopJogadores(Integer top) {
        List<Jogador> jogadorList = Jogador.jogadorList;
        Collections.sort(jogadorList);
        List<Long> idTopJogadoresList = new ArrayList<>();

        for (Jogador jogador : jogadorList) {
            if (idTopJogadoresList.size() == top) {
                break;
            }
            idTopJogadoresList.add(jogador.getIdJogador());
        }
        return idTopJogadoresList;
    }

    public BigDecimal findJogadorSalary(Long idJogador) {
        List<Jogador> jogadorList = Jogador.jogadorList;
        BigDecimal bigDecimal = BigDecimal.valueOf(0);

        for(Jogador jogador : jogadorList){
            if(jogador.getIdJogador().equals(idJogador)){
                bigDecimal = BigDecimal.valueOf(jogador.getSalario().doubleValue());
            }
        }
        return bigDecimal;
    }

    public List<Long> findAll(){
        List<Long> idJogadorList = new ArrayList<>();

        for (Jogador jogador : Jogador.jogadorList) {
            idJogadorList.add(jogador.getIdJogador());
        }

        return idJogadorList;
    }

    public Long findHigherSalaryJogadorByTime(Long idTime) {
        List<Jogador> jogadorList = new ArrayList<>();
        BigDecimal salary = BigDecimal.valueOf(0);
        Long idHigherSalaryJogador = 0L;

        for (Jogador jogador : Jogador.jogadorList) {
            if (idTime.equals(jogador.getIdTime())) {
                jogadorList.add(jogador);
            }
        }

        for (Jogador jogador : jogadorList) {
            if (jogador.getSalario().doubleValue() > salary.doubleValue()) {
                salary = jogador.getSalario();
                idHigherSalaryJogador = jogador.getIdJogador();
            }else if (jogador.getSalario().equals(salary) && jogador.getIdJogador() < idHigherSalaryJogador) {
                salary = jogador.getSalario();
                idHigherSalaryJogador = jogador.getIdJogador();
            }
        }
        return idHigherSalaryJogador;
    }

    public String findName(Long idJogador) {
        List<Jogador> jogadorList = Jogador.jogadorList;
        String nameJogador = "";

        for(Jogador jogador : jogadorList){
            if(jogador.getIdJogador().equals(idJogador)){
                nameJogador = jogador.getNome();
            }
        }
        return nameJogador;
    }
}
