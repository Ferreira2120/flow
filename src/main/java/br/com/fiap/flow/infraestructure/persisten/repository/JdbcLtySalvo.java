package br.com.fiap.flow.infraestructure.persisten.repository;

import br.com.fiap.flow.aplication.exceptions.ExceptionInfra;
import br.com.fiap.flow.domain.exceptions.ErrorFindingEntity;
import br.com.fiap.flow.domain.model.LtySalvo;
import br.com.fiap.flow.domain.repository.LtySalvoRepository;
import br.com.fiap.flow.infraestructure.exceptions.ExceptionOfInfra;
import br.com.fiap.flow.infraestructure.persisten.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcLtySalvo implements LtySalvoRepository {

    private final ConnectionDB connectionDB;

    public JdbcLtySalvo(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public LtySalvo salvar(LtySalvo ltySalvo) {

        String sql = "INSERT INTO T_LAYOUT_SALVO (NM_LAYOUT, ID_USUARIO, DT_CRIACAO) VALUES (?, ?, ?)";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, ltySalvo.getNmLayout());
            stmt.setLong(2, ltySalvo.getIdUsuario());
            stmt.setDate(3, java.sql.Date.valueOf(ltySalvo.getDataCriacao()));

            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas == 0){
                throw new RuntimeException("Falha ao salvar layout, nenhuma linha afetada.");
            }
            return ltySalvo;
        }catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar layout!", e);
        }
    }

    @Override
    public LtySalvo buscarPorId(Long id) throws ErrorFindingEntity {
        String sql = "SELECT * FROM T_LAYOUT_SALVO WHERE ID_LAYOUT_SALVO = ?";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setLong(1, id);

            var rs = stmt.executeQuery();
            if(rs.next()) {
                return new LtySalvo(
                    rs.getLong("ID_LAYOUT_SALVO"),
                    rs.getString("NM_LAYOUT"),
                    rs.getLong("ID_USUARIO"),
                    rs.getDate("DT_CRIACAO").toLocalDate()
                );
            } else {
                throw new ExceptionInfra("Layout não encontrado com o ID: " + id);
            }
        } catch (SQLException e) {
            throw new ErrorFindingEntity("Erro ao buscar layout por ID!", e);
        }
    }

    @Override
    public LtySalvo atualizar(LtySalvo ltySalvo) {
        String sql = "UPDATE T_LAYOUT_SALVO SET NM_LAYOUT = ?, ID_USUARIO = ?, DT_CRIACAO = ? WHERE ID_LAYOUT_SALVO = ?";

        try (Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ltySalvo.getNmLayout());
            stmt.setLong(2, ltySalvo.getIdUsuario());
            stmt.setDate(3, java.sql.Date.valueOf(ltySalvo.getDataCriacao()));
            stmt.setLong(4, ltySalvo.getIdLtySalvo());

            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas == 0){
                throw new ExceptionOfInfra("Falha ao atualizar layout, nenhuma linha afetada.");
            }
            return ltySalvo;
        } catch (SQLException e) {
            throw new ExceptionOfInfra("Erro ao atualizar layout!", e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM T_LAYOUT_SALVO WHERE ID_LAYOUT_SALVO = ?";

        try (Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas == 0){
                throw new ExceptionOfInfra("Falha ao deletar layout, nenhuma linha afetada.");
            }
        } catch (SQLException e) {
            throw new ExceptionOfInfra("Erro ao deletar layout!", e);
        }
    }
}
