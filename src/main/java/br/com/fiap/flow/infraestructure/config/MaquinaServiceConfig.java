package br.com.fiap.flow.infraestructure.config;

import br.com.fiap.flow.aplication.service.MaquinaServiceImpl;
import br.com.fiap.flow.domain.repository.MaquinaRepository;
import br.com.fiap.flow.domain.service.MaquinaService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MaquinaServiceConfig {

    @ApplicationScoped
    public MaquinaService maquinaService(MaquinaRepository maquinaRepository){
        return new MaquinaServiceImpl(maquinaRepository);
    }

}
