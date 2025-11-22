package br.com.fiap.flow.domain.service;

import br.com.fiap.flow.domain.model.Usuario;

public interface UsuarioService {

    Usuario salvarService(Usuario usuario);

    Usuario buscarPorEmailService(String email);

    Usuario buscarPorIdService(Long idUsuario);

    Usuario atualizarService(Usuario usuario);

    void deletarService(Long idUsuario);

}
