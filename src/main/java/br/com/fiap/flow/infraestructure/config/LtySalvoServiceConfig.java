package br.com.fiap.flow.infraestructure.config;

import br.com.fiap.flow.aplication.service.LtySalvoServiceImpl;
import br.com.fiap.flow.domain.repository.LtySalvoRepository;
import br.com.fiap.flow.domain.service.LtySalvoService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LtySalvoServiceConfig {

    @ApplicationScoped
    public LtySalvoService ltySalvoService(LtySalvoRepository ltySalvoRepository){
        return new LtySalvoServiceImpl(ltySalvoRepository);
    }

}
