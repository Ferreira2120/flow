package br.com.fiap.flow.interfaces;

import br.com.fiap.flow.domain.model.Maquina;
import br.com.fiap.flow.domain.service.MaquinaService;
import br.com.fiap.flow.interfaces.dto.output.MaquinaDto;
import br.com.fiap.flow.interfaces.mapper.MaquinaMapper;

public class MaquinaControllerImpl implements MaquinaController{

    private final MaquinaService maquinaService;

    public MaquinaControllerImpl(MaquinaService maquinaService) {
        this.maquinaService = maquinaService;
    }


    @Override
    public MaquinaDto criarMaquina(Maquina maquina) {
        Maquina maquina1 =maquinaService.salvarService(maquina);
        return MaquinaMapper.toDtoMaquina(maquina1);
    }

    @Override
    public MaquinaDto obterMaquinaPorId(Long idMaquina) {
        Maquina maquina1 =maquinaService.buscarPorIdService(idMaquina);
        return MaquinaMapper.toDtoMaquina(maquina1);
    }

    @Override
    public MaquinaDto atualizarMaquina(Maquina maquina) {
        Maquina maquina1 =maquinaService.atualizarService(maquina);
        return MaquinaMapper.toDtoMaquina(maquina1);
    }

    @Override
    public void deletarMaquina(Long idMaquina) {
        maquinaService.deletarService(idMaquina);
    }
}
