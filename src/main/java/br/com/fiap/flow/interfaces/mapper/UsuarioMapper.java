package br.com.fiap.flow.interfaces.mapper;

import br.com.fiap.flow.interfaces.dto.output.UsuarioDto;

public class UsuarioMapper {

    public UsuarioMapper() {
    }

    public static UsuarioDto toDtoUsuario(br.com.fiap.flow.domain.model.Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getDtCadastro()
        );
        return usuarioDto;
    }
}
