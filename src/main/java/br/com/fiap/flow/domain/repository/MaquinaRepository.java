package br.com.fiap.flow.domain.repository;

import br.com.fiap.flow.domain.exceptions.ErrorFindingEntity;
import br.com.fiap.flow.domain.model.Maquina;

import java.util.List;

public interface MaquinaRepository {

    Maquina salvar(Maquina maquina);

    Maquina buscarPorId(Long idMaquina) throws ErrorFindingEntity;

    Maquina atualizar(Maquina maquina);

    List<Maquina> buscarTodos();

    void deletar(Long idMaquina);

}
