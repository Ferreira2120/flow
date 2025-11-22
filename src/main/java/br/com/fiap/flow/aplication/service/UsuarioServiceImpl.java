package br.com.fiap.flow.aplication.service;

import br.com.fiap.flow.domain.model.Usuario;
import br.com.fiap.flow.domain.repository.UsuarioRepository;
import br.com.fiap.flow.domain.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario salvarService(Usuario usuario) {
        return this.usuarioRepository.salvar(usuario);
    }

    @Override
    public Usuario buscarPorEmailService(String email) {
        return this.usuarioRepository.buscarPorEmail(email);
    }

    @Override
    public Usuario buscarPorIdService(Long idUsuario) {
        return this.usuarioRepository.buscarPorId(idUsuario);
    }

    @Override
    public Usuario atualizarService(Usuario usuario) {
        return this.usuarioRepository.atualizar(usuario);
    }

    @Override
    public void deletarService(Long idUsuario) {
        this.usuarioRepository.deletar(idUsuario);
    }
}
