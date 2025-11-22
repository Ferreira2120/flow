package br.com.fiap.flow.interfaces;

import br.com.fiap.flow.domain.model.Maquina;
import br.com.fiap.flow.interfaces.dto.output.MaquinaDto;

public interface MaquinaController {

    MaquinaDto criarMaquina(Maquina maquina);

    MaquinaDto obterMaquinaPorId(Long idMaquina);

    MaquinaDto atualizarMaquina(Maquina maquina);

    void deletarMaquina(Long idMaquina);

}
