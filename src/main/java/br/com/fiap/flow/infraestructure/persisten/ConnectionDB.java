package br.com.fiap.flow.infraestructure.persisten;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionDB {

    Connection getConnection() throws SQLException;

}
