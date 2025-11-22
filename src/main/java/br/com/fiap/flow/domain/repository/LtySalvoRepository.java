package br.com.fiap.flow.domain.repository;

import br.com.fiap.flow.domain.exceptions.ErrorFindingEntity;
import br.com.fiap.flow.domain.model.LtySalvo;

public interface LtySalvoRepository {

    LtySalvo salvar(LtySalvo ltySalvo);

    LtySalvo buscarPorId(Long id) throws ErrorFindingEntity;

    LtySalvo atualizar(LtySalvo ltySalvo);

    void deletar(Long id);

}
