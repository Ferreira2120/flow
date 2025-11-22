package br.com.fiap.flow.domain.repository;

import br.com.fiap.flow.domain.exceptions.ErrorFindingEntity;
import br.com.fiap.flow.domain.model.Maquina;

public interface MaquinaRepository {

    Maquina salvar(Maquina maquina);

    Maquina buscarPorId(Long idMaquina) throws ErrorFindingEntity;

    Maquina atualizar(Maquina maquina);

    void deletar(Long idMaquina);

}
