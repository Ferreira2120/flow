package br.com.fiap.flow.domain.model;

import java.time.LocalDate;

public class LtySalvo {

    private Long idLtySalvo;

    private String nmLayout;

    private Long idUsuario;

    private LocalDate dataCriacao;

    public LtySalvo() {
    }

    public LtySalvo(Long idLtySalvo, String nmLayout, Long idUsuario, LocalDate dataCriacao) {
        this.idLtySalvo = idLtySalvo;
        this.nmLayout = nmLayout;
        this.idUsuario = idUsuario;
        this.dataCriacao = dataCriacao;
    }

    public LtySalvo(String nmLayout, Long idUsuario, LocalDate dataCriacao) {
        this.nmLayout = nmLayout;
        this.idUsuario = idUsuario;
        this.dataCriacao = dataCriacao;
    }

    public Long getIdLtySalvo() {
        return idLtySalvo;
    }

    public String getNmLayout() {
        return nmLayout;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
}
