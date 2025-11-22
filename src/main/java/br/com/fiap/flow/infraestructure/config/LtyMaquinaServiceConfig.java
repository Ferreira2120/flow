package br.com.fiap.flow.infraestructure.config;

import br.com.fiap.flow.aplication.service.LtyMaquinaServiceImpl;
import br.com.fiap.flow.domain.repository.LtyMaquinaRepository;
import br.com.fiap.flow.domain.service.LtyMaquinaService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LtyMaquinaServiceConfig {

    @ApplicationScoped
    public LtyMaquinaService ltyMaquinaService(LtyMaquinaRepository ltyMaquinaRepository) {
        return new LtyMaquinaServiceImpl(ltyMaquinaRepository);
    }

}
