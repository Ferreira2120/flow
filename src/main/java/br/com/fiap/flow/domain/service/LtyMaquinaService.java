package br.com.fiap.flow.domain.service;

import br.com.fiap.flow.domain.exceptions.ErrorFindingEntity;
import br.com.fiap.flow.domain.model.LtyMaquina;

public interface LtyMaquinaService {

    LtyMaquina salvar(LtyMaquina ltyMaquina);

    LtyMaquina buscarPorId(Long id) throws ErrorFindingEntity;

    LtyMaquina atualizar(LtyMaquina ltyMaquina);

    void deletar(Long id);

}
