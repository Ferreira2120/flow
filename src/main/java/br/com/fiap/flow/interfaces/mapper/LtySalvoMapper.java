package br.com.fiap.flow.interfaces.mapper;

import br.com.fiap.flow.domain.model.LtySalvo;
import br.com.fiap.flow.interfaces.dto.output.LtySalvoDto;

public class LtySalvoMapper {

    public LtySalvoMapper() {
    }

    public static LtySalvoDto toDtoLtySalvo(LtySalvo ltySalvo){
        LtySalvoDto ltySalvoDto = new LtySalvoDto(
            ltySalvo.getIdLtySalvo(),
            ltySalvo.getNmLayout(),
            ltySalvo.getIdUsuario(),
            ltySalvo.getDataCriacao()
        );
        return ltySalvoDto;
    }

}
