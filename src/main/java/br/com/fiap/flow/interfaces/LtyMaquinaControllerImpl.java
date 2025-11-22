package br.com.fiap.flow.interfaces;

import br.com.fiap.flow.domain.model.LtyMaquina;
import br.com.fiap.flow.domain.service.LtyMaquinaService;
import br.com.fiap.flow.interfaces.dto.output.LtyMaquinaDto;
import br.com.fiap.flow.interfaces.mapper.LtyMaquinaMapper;

public class LtyMaquinaControllerImpl implements LtyMaquinaController{

    private final LtyMaquinaService ltyMaquinaService;

    public LtyMaquinaControllerImpl(LtyMaquinaService ltyMaquinaService) {
        this.ltyMaquinaService = ltyMaquinaService;
    }

    @Override
    public LtyMaquinaDto salvarLtyMaquina(LtyMaquina ltyMaquinaDto) {
        LtyMaquina ltyMaquina = ltyMaquinaService.salvar(ltyMaquinaDto);
        return LtyMaquinaMapper.toDtoLtyMaquina(ltyMaquina);
    }

    @Override
    public LtyMaquinaDto buscarLtyMaquinaPorId(Long idLtyMaquina) {
        LtyMaquina ltyMaquina = ltyMaquinaService.buscarPorId(idLtyMaquina);
        return LtyMaquinaMapper.toDtoLtyMaquina(ltyMaquina);
    }

    @Override
    public LtyMaquinaDto atualizarLtyMaquina(LtyMaquina ltyMaquinaDto) {
        LtyMaquina ltyMaquina = ltyMaquinaService.atualizar(ltyMaquinaDto);
        return LtyMaquinaMapper.toDtoLtyMaquina(ltyMaquina);
    }

    @Override
    public void deletarLtyMaquina(Long idLtyMaquina) {
            ltyMaquinaService.deletar(idLtyMaquina);
    }
}
