package br.com.fiap.flow.infraestructure.config;

import br.com.fiap.flow.domain.repository.LtyMaquinaRepository;
import br.com.fiap.flow.domain.repository.LtySalvoRepository;
import br.com.fiap.flow.domain.repository.MaquinaRepository;
import br.com.fiap.flow.domain.repository.UsuarioRepository;
import br.com.fiap.flow.infraestructure.persisten.ConnectionDB;
import br.com.fiap.flow.infraestructure.persisten.ConnectionDBImpl;
import br.com.fiap.flow.infraestructure.persisten.repository.JdbcLtyMaquina;
import br.com.fiap.flow.infraestructure.persisten.repository.JdbcLtySalvo;
import br.com.fiap.flow.infraestructure.persisten.repository.JdbcMaquina;
import br.com.fiap.flow.infraestructure.persisten.repository.JdbcUsuario;
import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConfigDb {

    @ApplicationScoped
    public ConnectionDB connectionDB(AgroalDataSource agroalDataSource){
        return new ConnectionDBImpl(agroalDataSource);
    }

    @ApplicationScoped
    public LtyMaquinaRepository ltyMaquinaRepository(ConnectionDB connectionDB){
        return new JdbcLtyMaquina(connectionDB);
    }

    @ApplicationScoped
    public LtySalvoRepository ltySalvoRepository(ConnectionDB connectionDB){
        return new JdbcLtySalvo(connectionDB);
    }

    @ApplicationScoped
    public MaquinaRepository maquinaRepository(ConnectionDB connectionDB){
        return new JdbcMaquina(connectionDB);
    }

    @ApplicationScoped
    public UsuarioRepository usuarioRepository(ConnectionDB connectionDB){
        return new JdbcUsuario(connectionDB);
    }

}
