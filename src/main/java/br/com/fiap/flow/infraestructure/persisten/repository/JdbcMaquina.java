package br.com.fiap.flow.infraestructure.persisten.repository;

import br.com.fiap.flow.domain.exceptions.ErrorFindingEntity;
import br.com.fiap.flow.domain.model.Maquina;
import br.com.fiap.flow.domain.repository.MaquinaRepository;
import br.com.fiap.flow.infraestructure.exceptions.ExceptionOfInfra;
import br.com.fiap.flow.infraestructure.persisten.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcMaquina implements MaquinaRepository {

    private final ConnectionDB connectionDB;

    public JdbcMaquina(ConnectionDB connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public Maquina salvar(Maquina maquina) {

        String sql = "INSERT INTO T_MAQUINA (NM_MAQUINA, NR_TEMPO_CICLO, DS_DESCRICAO) VALUES (?, ?, ?)";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, maquina.getNmMaquina());
            stmt.setFloat(2, maquina.getTempoCiclo());
            stmt.setString(3, maquina.getDescricao());

            int linhasAfetadas = stmt.executeUpdate();
            if(linhasAfetadas == 0){
                throw new ExceptionOfInfra("Falha ao salvar máquina, nenhuma linha afetada.");
            }
            return maquina;

        }catch (SQLException e) {
            throw new ExceptionOfInfra("Erro ao salvar máquina!", e);
        }
    }

    @Override
    public Maquina buscarPorId(Long idMaquina) throws ErrorFindingEntity {
        String sql = "SELECT * FROM T_MAQUINA WHERE ID_MAQUINA = ?";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setLong(1, idMaquina);

            var rs = stmt.executeQuery();
            if(rs.next()) {
                Maquina maquina = new Maquina(
                    rs.getLong("ID_MAQUINA"),
                    rs.getString("NM_MAQUINA"),
                    rs.getFloat("NR_TEMPO_CICLO"),
                    rs.getString("DS_DESCRICAO")
                );
                return maquina;
            } else {
                throw new ExceptionOfInfra("Não foi possível buscar a máquina com o ID informado.");
            }

        } catch (SQLException e) {
            throw new ErrorFindingEntity("Erro ao buscar máquina por ID!", e);
        }

    }

    @Override
    public Maquina atualizar(Maquina maquina) {
        String sql = "UPDATE T_MAQUINA SET NM_MAQUINA = ?, NR_TEMPO_CICLO = ?, DS_DESCRICAO = ? WHERE ID_MAQUINA = ?";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maquina.getNmMaquina());
            stmt.setFloat(2, maquina.getTempoCiclo());
            stmt.setString(3, maquina.getDescricao());
            stmt.setLong(4, maquina.getIdMaquina());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new ExceptionOfInfra("Falha ao atualizar máquina, nenhuma linha afetada.");
            }
            return maquina;
        }catch (SQLException e){
            throw new ExceptionOfInfra("Erro ao atualizar máquina!", e);
        }
    }

    @Override
    public void deletar(Long idMaquina) {
        String sql = "DELETE FROM T_MAQUINA WHERE ID_MAQUINA = ?";

        try(Connection conn = this.connectionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, idMaquina);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new ExceptionOfInfra("Falha ao deletar máquina, nenhuma linha afetada.");
            }
        }catch (SQLException e){
            throw new ExceptionOfInfra("Erro ao deletar máquina!", e);
        }
    }
}
