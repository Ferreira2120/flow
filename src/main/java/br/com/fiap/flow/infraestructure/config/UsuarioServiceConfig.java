package br.com.fiap.flow.infraestructure.config;

import br.com.fiap.flow.aplication.service.UsuarioServiceImpl;
import br.com.fiap.flow.domain.repository.UsuarioRepository;
import br.com.fiap.flow.domain.service.UsuarioService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioServiceConfig {

    @ApplicationScoped
    public UsuarioService usuarioService(UsuarioRepository usuarioRepository){
        return new UsuarioServiceImpl(usuarioRepository);
    }

}
