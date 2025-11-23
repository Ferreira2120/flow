package br.com.fiap.flow.domain.service;

import br.com.fiap.flow.domain.model.Maquina;

import java.util.List;

public interface MaquinaService {

    Maquina salvarService(Maquina maquina);

    Maquina buscarPorIdService(Long idMaquina);

    Maquina atualizarService(Maquina maquina);

    List<Maquina> buscarTodosService();

    void deletarService(Long idMaquina);

}
