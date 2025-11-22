package br.com.fiap.flow.domain.model;

import java.time.LocalDateTime;

public class Maquina {

    private Long idMaquina;

    private String nmMaquina;

    private float tempoCiclo;

    private String descricao;

    public Maquina() {
    }

    public Maquina(Long idMaquina, String nmMaquina, float tempoCiclo, String descricao) {
        this.idMaquina = idMaquina;
        this.nmMaquina = nmMaquina;
        this.tempoCiclo = tempoCiclo;
        this.descricao = descricao;
    }

    public Maquina(String nmMaquina, float tempoCiclo, String descricao) {
        this.nmMaquina = nmMaquina;
        this.tempoCiclo = tempoCiclo;
        this.descricao = descricao;
    }

    public Long getIdMaquina() {
        return idMaquina;
    }

    public String getNmMaquina() {
        return nmMaquina;
    }

    public float getTempoCiclo() {
        return tempoCiclo;
    }

    public String getDescricao() {
        return descricao;
    }
}
