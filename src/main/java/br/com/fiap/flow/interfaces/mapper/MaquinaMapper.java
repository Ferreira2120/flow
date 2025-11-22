package br.com.fiap.flow.interfaces.mapper;

import br.com.fiap.flow.domain.model.Maquina;
import br.com.fiap.flow.interfaces.dto.output.MaquinaDto;

public class MaquinaMapper {

    public MaquinaMapper() {
    }

    public static MaquinaDto toDtoMaquina(Maquina maquina){
        MaquinaDto maquinaDto = new MaquinaDto(
                maquina.getIdMaquina(),
                maquina.getNmMaquina(),
                maquina.getTempoCiclo(),
                maquina.getDescricao()
        );
        return maquinaDto;
    }
}
