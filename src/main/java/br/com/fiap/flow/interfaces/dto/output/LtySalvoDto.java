package br.com.fiap.flow.interfaces.dto.output;

import java.time.LocalDate;

public class LtySalvoDto {

    private Long idLtySalvo;

    private String nmLayout;

    private Long idUsuario;

    private LocalDate dataCriacao;

    public LtySalvoDto() {
    }

    public LtySalvoDto(Long idLtySalvo, String nmLayout, Long idUsuario, LocalDate dataCriacao) {
        this.idLtySalvo = idLtySalvo;
        this.nmLayout = nmLayout;
        this.idUsuario = idUsuario;
        this.dataCriacao = dataCriacao;
    }

    public LtySalvoDto(String nmLayout, Long idUsuario, LocalDate dataCriacao) {
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
