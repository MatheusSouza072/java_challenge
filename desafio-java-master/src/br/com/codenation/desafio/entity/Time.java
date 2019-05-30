package br.com.codenation.desafio.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {

    private Long idTime;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private Long capitao;
    public static List<Time> timeList;

    static {
        timeList = new ArrayList<>();
    }

    public Time(Long idTime, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.idTime = idTime;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public Long getIdTime() {
        return idTime;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public Long getCapitao() {
        return capitao;
    }

    public void setCapitao(Long capitao) {
        this.capitao = capitao;
    }
}
