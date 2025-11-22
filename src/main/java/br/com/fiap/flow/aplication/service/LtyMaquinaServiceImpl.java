package br.com.fiap.flow.aplication.service;

import br.com.fiap.flow.domain.exceptions.ErrorFindingEntity;
import br.com.fiap.flow.domain.model.LtyMaquina;
import br.com.fiap.flow.domain.repository.LtyMaquinaRepository;
import br.com.fiap.flow.domain.service.LtyMaquinaService;
import br.com.fiap.flow.infraestructure.exceptions.ExceptionOfInfra;

import java.sql.SQLException;

public class LtyMaquinaServiceImpl implements LtyMaquinaService {

    private final LtyMaquinaRepository ltyMaquinaRepository;

    public LtyMaquinaServiceImpl(LtyMaquinaRepository ltyMaquinaRepository) {
        this.ltyMaquinaRepository = ltyMaquinaRepository;
    }

    @Override
    public LtyMaquina salvar(LtyMaquina ltyMaquina) {
        return this.ltyMaquinaRepository.salvar(ltyMaquina);
    }

    @Override
    public LtyMaquina buscarPorId(Long id) throws ErrorFindingEntity {
        try{
            return this.ltyMaquinaRepository.buscarPorId(id);
        }catch (ErrorFindingEntity e){
            throw e;
        }
    }

    @Override
    public LtyMaquina atualizar(LtyMaquina ltyMaquina) {
        return this.ltyMaquinaRepository.atualizar(ltyMaquina);
    }

    @Override
    public void deletar(Long id) {
        ltyMaquinaRepository.deletar(id);
    }
}
