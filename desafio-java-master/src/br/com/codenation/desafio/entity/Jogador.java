package br.com.codenation.desafio.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Jogador implements Comparable<Jogador> {

    private Long idJogador;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;
    public static List<Jogador> jogadorList;

    static {
        jogadorList = new ArrayList<>();
    }

    public Jogador(Long idJogador, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.idJogador = idJogador;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
    }

    public Long getIdJogador() {
        return idJogador;
    }

    public Long getIdTime() {
        return idTime;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public int compareTo(Jogador jogador) {
        if (this.nivelHabilidade > jogador.getNivelHabilidade()) {
            return -1;
        }
        if (this.nivelHabilidade < jogador.getNivelHabilidade()) {
            return 1;
        }
        return 0;
    }
}
