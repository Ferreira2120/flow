package br.com.fiap.flow.domain.model;

public class LtyMaquina {

    private Long idLtyMaquina;

    private Long idMaquina;

    private float positionX;

    private float positionY;

    public LtyMaquina() {
    }

    public LtyMaquina(Long idLtyMaquina, Long idMaquina, float positionX, float positionY) {
        this.idLtyMaquina = idLtyMaquina;
        this.idMaquina = idMaquina;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public LtyMaquina(Long idMaquina, float positionX, float positionY) {
        this.idMaquina = idMaquina;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Long getIdLtyMaquina() {
        return idLtyMaquina;
    }

    public Long getIdMaquina() {
        return idMaquina;
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }
}
