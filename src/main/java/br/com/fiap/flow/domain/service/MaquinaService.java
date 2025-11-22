package br.com.fiap.flow.domain.service;

import br.com.fiap.flow.domain.model.Maquina;

public interface MaquinaService {

    Maquina salvarService(Maquina maquina);

    Maquina buscarPorIdService(Long idMaquina);

    Maquina atualizarService(Maquina maquina);

    void deletarService(Long idMaquina);

}
