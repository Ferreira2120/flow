package br.com.fiap.flow.interfaces.mapper;

import br.com.fiap.flow.domain.model.Maquina;
import br.com.fiap.flow.interfaces.dto.output.MaquinaDto;

import java.util.List;

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

    public static List<MaquinaDto> toDtoListMaquina(List<Maquina> maquinas){
        return maquinas.stream().map(MaquinaMapper::toDtoMaquina).toList();
    }

}
