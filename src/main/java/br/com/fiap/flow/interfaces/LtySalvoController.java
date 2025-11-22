package br.com.fiap.flow.interfaces;

import br.com.fiap.flow.domain.model.LtySalvo;
import br.com.fiap.flow.interfaces.dto.output.LtySalvoDto;

public interface LtySalvoController {

    LtySalvoDto salvarController(LtySalvo ltySalvoDto);

    LtySalvoDto buscarPorIdController(Long id);

    LtySalvoDto atualizarController(LtySalvo ltySalvoDto);

    void deletarController(Long id);

}
