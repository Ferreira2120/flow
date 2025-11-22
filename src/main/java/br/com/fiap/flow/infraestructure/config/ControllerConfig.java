package br.com.fiap.flow.infraestructure.config;

import br.com.fiap.flow.domain.service.LtyMaquinaService;
import br.com.fiap.flow.domain.service.LtySalvoService;
import br.com.fiap.flow.domain.service.MaquinaService;
import br.com.fiap.flow.domain.service.UsuarioService;
import br.com.fiap.flow.interfaces.*;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ControllerConfig {

    @ApplicationScoped
    public LtyMaquinaController ltyMaquinaController(LtyMaquinaService ltyMaquinaService){
        return new LtyMaquinaControllerImpl(ltyMaquinaService);
    }

    @ApplicationScoped
    public LtySalvoController ltySalvoController(LtySalvoService ltySalvoService){
        return new LtySalvoControllerImpl(ltySalvoService);
    }

    @ApplicationScoped
    public MaquinaController maquinaController(MaquinaService maquinaService){
        return new MaquinaControllerImpl(maquinaService);
    }

    @ApplicationScoped
    public UsuarioController usuarioController(UsuarioService usuarioService){
        return new UsuarioControllerImpl(usuarioService);
    }

}
