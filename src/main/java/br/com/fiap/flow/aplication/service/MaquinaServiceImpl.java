package br.com.fiap.flow.aplication.service;

import br.com.fiap.flow.domain.model.Maquina;
import br.com.fiap.flow.domain.repository.MaquinaRepository;
import br.com.fiap.flow.domain.service.MaquinaService;

public class MaquinaServiceImpl implements MaquinaService {

    private final MaquinaRepository maquinaRepository;

    public MaquinaServiceImpl(MaquinaRepository maquinaRepository) {
        this.maquinaRepository = maquinaRepository;
    }

    @Override
    public Maquina salvarService(Maquina maquina) {
        return this.maquinaRepository.salvar(maquina);
    }

    @Override
    public Maquina buscarPorIdService(Long idMaquina) {
        return this.maquinaRepository.buscarPorId(idMaquina);
    }

    @Override
    public Maquina atualizarService(Maquina maquina) {
        return this.maquinaRepository.atualizar(maquina);
    }

    @Override
    public void deletarService(Long idMaquina) {
        this.maquinaRepository.deletar(idMaquina);
    }
}
