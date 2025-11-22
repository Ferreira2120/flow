package br.com.fiap.flow.domain.repository;

import br.com.fiap.flow.domain.exceptions.ErrorFindingEntity;
import br.com.fiap.flow.domain.model.LtyMaquina;

public interface LtyMaquinaRepository {

    LtyMaquina salvar(LtyMaquina ltyMaquina);

    LtyMaquina buscarPorId(Long id) throws ErrorFindingEntity;

    LtyMaquina atualizar(LtyMaquina ltyMaquina);

    void deletar(Long id);

}
