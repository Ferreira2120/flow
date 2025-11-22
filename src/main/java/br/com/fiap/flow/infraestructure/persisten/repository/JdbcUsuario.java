package br.com.fiap.flow.infraestructure.persisten.repository;

import br.com.fiap.flow.domain.model.Usuario;
import br.com.fiap.flow.domain.repository.UsuarioRepository;
import br.com.fiap.flow.infraestructure.exceptions.ExceptionOfInfra;
import br.com.fiap.flow.infraestructure.persisten.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUsuario implements UsuarioRepository {

    private final ConnectionDB connectionDB;

    public JdbcUsuario(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public Usuario salvar(Usuario usuario) {

        String sql = "INSERT INTO USUARIO (NM_USUARIO, DS_EMAIL, DS_SENHA, DT_CADASTRO) VALUES (?, ?, ?, ?)";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setDate(4, java.sql.Date.valueOf(usuario.getDtCadastro()));

            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas == 0){
                throw new RuntimeException("Falha ao salvar usuário, nenhuma linha afetada.");
            }
            return usuario;
        } catch (SQLException e) {
            throw new ExceptionOfInfra("Erro ao salvar usuário!", e);
        }
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        String sql = "SELECT * FROM USUARIO WHERE DS_EMAIL = ?";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, email);

            var rs = stmt.executeQuery();
            if(rs.next()) {
                return new Usuario(
                    rs.getLong("ID_USUARIO"),
                    rs.getString("NM_USUARIO"),
                    rs.getString("DS_EMAIL"),
                    rs.getString("DS_SENHA"),
                    rs.getDate("DT_CADASTRO").toLocalDate()
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new ExceptionOfInfra("Erro ao buscar usuário por email!", e);
        }
    }

    @Override
    public Usuario buscarPorId(Long idUsuario) {
        String sql = "SELECT * FROM USUARIO WHERE ID_USUARIO = ?";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, idUsuario);

            var rs = stmt.executeQuery();
            if(rs.next()) {
                return new Usuario(
                    rs.getLong("ID_USUARIO"),
                    rs.getString("NM_USUARIO"),
                    rs.getString("DS_EMAIL"),
                    rs.getString("DS_SENHA"),
                    rs.getDate("DT_CADASTRO").toLocalDate()
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new ExceptionOfInfra("Erro ao buscar usuário por ID!", e);
        }
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        String sql = "UPDATE USUARIO SET NM_USUARIO = ?, DS_EMAIL = ?, DS_SENHA = ? WHERE ID_USUARIO = ?";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setLong(4, usuario.getIdUsuario());

            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas == 0){
                throw new RuntimeException("Falha ao atualizar usuário, nenhuma linha afetada.");
            }
            return usuario;
        } catch (SQLException e) {
            throw new ExceptionOfInfra("Erro ao atualizar usuário!", e);
        }
    }

    @Override
    public void deletar(Long idUsuario) {
        String sql = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, idUsuario);

            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas == 0){
                throw new RuntimeException("Falha ao deletar usuário, nenhuma linha afetada.");
            }
        } catch (SQLException e) {
            throw new ExceptionOfInfra("Erro ao deletar usuário!", e);
        }
    }
}
