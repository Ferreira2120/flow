package br.com.fiap.flow.domain.repository;

import br.com.fiap.flow.domain.model.Usuario;

public interface UsuarioRepository {

    Usuario salvar(Usuario usuario);

    Usuario buscarPorEmail(String email);

    Usuario buscarPorId(Long idUsuario);

    Usuario atualizar(Usuario usuario);

    void deletar(Long idUsuario);

}
