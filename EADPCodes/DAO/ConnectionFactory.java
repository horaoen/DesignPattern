package DAO;

import java.sql.Connection;

public interface ConnectionFactory {

	public Connection getConnection();

}