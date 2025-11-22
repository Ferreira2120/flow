package br.com.fiap.flow.infraestructure.persisten.repository;

import br.com.fiap.flow.domain.exceptions.ErrorFindingEntity;
import br.com.fiap.flow.domain.model.LtyMaquina;
import br.com.fiap.flow.domain.repository.LtyMaquinaRepository;
import br.com.fiap.flow.infraestructure.exceptions.ExceptionOfInfra;
import br.com.fiap.flow.infraestructure.persisten.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcLtyMaquina implements LtyMaquinaRepository {

    private final ConnectionDB connectionDB;

    public JdbcLtyMaquina(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public LtyMaquina salvar(LtyMaquina ltyMaquina) {
         String sql = "INSERT INTO T_LAYOUT_MAQUINA (ID_MAQUINA, POSICAO_X, POSICAO_Y) VALUES (?, ?, ?)";

         try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

             stmt.setLong(1, ltyMaquina.getIdMaquina());
             stmt.setFloat(2, ltyMaquina.getPositionX());
             stmt.setFloat(3, ltyMaquina.getPositionY());

             int linhasAfetadas = stmt.executeUpdate();
             if(linhasAfetadas == 0){
                 throw new RuntimeException("Falha ao salvar layout da máquina, nenhuma linha afetada.");
             }
             return ltyMaquina;
         } catch (Exception e) {
             throw new RuntimeException("Erro ao salvar layout da máquina!", e);
         }

    }

    @Override
    public LtyMaquina buscarPorId(Long id) throws ErrorFindingEntity {
        String sql = "SELECT * FROM T_LAYOUT_MAQUINA WHERE ID_LAYOUT_MAQUINA = ?";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setLong(1, id);

            var rs = stmt.executeQuery();
            if(rs.next()) {
                Long idLtyMaquina = rs.getLong("ID_LAYOUT_MAQUINA");
                Long idMaquina = rs.getLong("ID_MAQUINA");
                float positionX = rs.getFloat("POSICAO_X");
                float positionY = rs.getFloat("POSICAO_Y");

                return new LtyMaquina(idLtyMaquina, idMaquina, positionX, positionY);
            } else {
                throw new ErrorFindingEntity("Layout da máquina não encontrado para o ID: " + id);
            }
        } catch (SQLException e) {
            throw new ErrorFindingEntity("Erro ao buscar layout da máquina!", e);
        }

    }

    @Override
    public LtyMaquina atualizar(LtyMaquina ltyMaquina) {
        String sql = "UPDATE T_LAYOUT_MAQUINA SET ID_MAQUINA = ?, POSICAO_X = ?, POSICAO_Y = ? WHERE ID_LAYOUT_MAQUINA = ?";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setLong(1, ltyMaquina.getIdMaquina());
            stmt.setFloat(2, ltyMaquina.getPositionX());
            stmt.setFloat(3, ltyMaquina.getPositionY());
            stmt.setLong(4, ltyMaquina.getIdLtyMaquina());

            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas == 0){
                throw new RuntimeException("Falha ao atualizar layout da máquina, nenhuma linha afetada.");
            }
            return ltyMaquina;
        } catch (SQLException e) {
            throw new ExceptionOfInfra("Erro ao atualizar layout da máquina!", e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM T_LAYOUT_MAQUINA WHERE ID_LAYOUT_MAQUINA = ?";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setLong(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas == 0){
                throw new RuntimeException("Falha ao deletar layout da máquina, nenhuma linha afetada.");
            }
        } catch (SQLException e) {
            throw new ExceptionOfInfra("Erro ao deletar layout da máquina!", e);
        }
    }
}
