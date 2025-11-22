package br.com.fiap.flow.interfaces;

import br.com.fiap.flow.domain.model.LtySalvo;
import br.com.fiap.flow.domain.service.LtySalvoService;
import br.com.fiap.flow.interfaces.dto.output.LtySalvoDto;
import br.com.fiap.flow.interfaces.mapper.LtySalvoMapper;

public class LtySalvoControllerImpl implements LtySalvoController{

    private final LtySalvoService ltySalvoService;

    public LtySalvoControllerImpl(LtySalvoService ltySalvoService) {
        this.ltySalvoService = ltySalvoService;
    }

    @Override
    public LtySalvoDto salvarController(LtySalvo ltySalvoDto) {
        LtySalvo ltySalvo = this.ltySalvoService.salvarService(ltySalvoDto);
        return LtySalvoMapper.toDtoLtySalvo(ltySalvo);
    }

    @Override
    public LtySalvoDto buscarPorIdController(Long id) {
        LtySalvo ltySalvo = this.ltySalvoService.buscarPorIdService(id);
        return LtySalvoMapper.toDtoLtySalvo(ltySalvo);
    }

    @Override
    public LtySalvoDto atualizarController(LtySalvo ltySalvoDto) {
        LtySalvo ltySalvo = this.ltySalvoService.atualizarService(ltySalvoDto);
        return LtySalvoMapper.toDtoLtySalvo(ltySalvo);
    }

    @Override
    public void deletarController(Long id) {
        this.ltySalvoService.deletarService(id);
    }
}
