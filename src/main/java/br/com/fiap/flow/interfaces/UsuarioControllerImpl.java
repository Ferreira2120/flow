package br.com.fiap.flow.interfaces;

import br.com.fiap.flow.domain.model.Usuario;
import br.com.fiap.flow.domain.service.UsuarioService;
import br.com.fiap.flow.interfaces.dto.output.UsuarioDto;
import br.com.fiap.flow.interfaces.mapper.UsuarioMapper;

public class UsuarioControllerImpl implements UsuarioController{

    private final UsuarioService usuarioService;

    public UsuarioControllerImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @Override
    public UsuarioDto salvarUsuario(Usuario usuario) {
        Usuario usuario1 = this.usuarioService.salvarService(usuario);
        return UsuarioMapper.toDtoUsuario(usuario1);
    }

    @Override
    public UsuarioDto obterUsuarioPorId(Long idUsuario) {
        Usuario usuario1 = this.usuarioService.buscarPorIdService(idUsuario);
        return UsuarioMapper.toDtoUsuario(usuario1);
    }

    @Override
    public UsuarioDto obterUsuarioPorEmail(String email) {
        Usuario usuario1 = this.usuarioService.buscarPorEmailService(email);
        return UsuarioMapper.toDtoUsuario(usuario1);
    }

    @Override
    public UsuarioDto atualizarUsuario(Usuario usuario) {
        Usuario usuario1 = this.usuarioService.atualizarService(usuario);
        return UsuarioMapper.toDtoUsuario(usuario1);
    }

    @Override
    public void deletarUsuario(Long idUsuario) {
        usuarioService.deletarService(idUsuario);
    }
}
