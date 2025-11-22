package br.com.fiap.flow.interfaces.mapper;

import br.com.fiap.flow.domain.model.LtyMaquina;
import br.com.fiap.flow.interfaces.dto.output.LtyMaquinaDto;

public class LtyMaquinaMapper {

    public LtyMaquinaMapper() {
    }

    public static LtyMaquinaDto toDtoLtyMaquina(LtyMaquina ltyMaquina){
        LtyMaquinaDto ltyMaquinaDto = new LtyMaquinaDto(
                ltyMaquina.getIdLtyMaquina(),
                ltyMaquina.getIdMaquina(),
                ltyMaquina.getPositionX(),
                ltyMaquina.getPositionY()
        );
        return ltyMaquinaDto;
    }
}
