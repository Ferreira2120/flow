package br.com.fiap.flow.domain.service;

import br.com.fiap.flow.domain.model.LtySalvo;

public interface LtySalvoService {

    LtySalvo salvarService(LtySalvo ltySalvo);

    LtySalvo buscarPorIdService(Long id);

    LtySalvo atualizarService(LtySalvo ltySalvo);

    void deletarService(Long id);

}
