package br.com.fiap.flow.interfaces;

import br.com.fiap.flow.domain.model.LtyMaquina;
import br.com.fiap.flow.interfaces.dto.output.LtyMaquinaDto;

public interface LtyMaquinaController {

    LtyMaquinaDto salvarLtyMaquina(LtyMaquina ltyMaquinaDto);

    LtyMaquinaDto buscarLtyMaquinaPorId(Long idLtyMaquina);

    LtyMaquinaDto atualizarLtyMaquina(LtyMaquina ltyMaquinaDto);

    void deletarLtyMaquina(Long idLtyMaquina);

}
