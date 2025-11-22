package br.com.fiap.flow.aplication.service;

import br.com.fiap.flow.domain.model.LtySalvo;
import br.com.fiap.flow.domain.repository.LtySalvoRepository;
import br.com.fiap.flow.domain.service.LtySalvoService;

public class LtySalvoServiceImpl implements LtySalvoService {

    private final LtySalvoRepository ltySalvoRepository;

    public LtySalvoServiceImpl(LtySalvoRepository ltySalvoRepository) {
        this.ltySalvoRepository = ltySalvoRepository;
    }

    @Override
    public LtySalvo salvarService(LtySalvo ltySalvo) {
        return this.ltySalvoRepository.salvar(ltySalvo);
    }

    @Override
    public LtySalvo buscarPorIdService(Long id) {
        return this.ltySalvoRepository.buscarPorId(id);
    }

    @Override
    public LtySalvo atualizarService(LtySalvo ltySalvo) {
        return this.ltySalvoRepository.atualizar(ltySalvo);
    }

    @Override
    public void deletarService(Long id) {
        this.ltySalvoRepository.deletar(id);
    }
}
