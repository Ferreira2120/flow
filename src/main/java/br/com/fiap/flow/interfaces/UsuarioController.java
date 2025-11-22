package br.com.fiap.flow.interfaces;

import br.com.fiap.flow.domain.model.Usuario;
import br.com.fiap.flow.interfaces.dto.output.UsuarioDto;

public interface UsuarioController {

    UsuarioDto salvarUsuario(Usuario usuario);

    UsuarioDto obterUsuarioPorId(Long idUsuario);

    UsuarioDto obterUsuarioPorEmail(String email);

    UsuarioDto atualizarUsuario(Usuario usuario);

    void deletarUsuario(Long idUsuario);

}
