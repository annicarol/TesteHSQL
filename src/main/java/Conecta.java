package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conecta {

	public boolean conexao()  {

		boolean conectou = true;
		
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			
			// abre a conexão
			Connection c = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/", "SA", "");
			
			// fecha a conexão
			 c = DriverManager.getConnection(
			         "jdbc:hsqldb:file:/opt/db/testdb;shutdown=true", "SA", "");			
			
			 return conectou;
			 
			 
			 
		} catch (Exception e) {
			conectou = false;			
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			
			return conectou;
		}

		

		// faz uma conexao
		//Statement stmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		//		ResultSet.CONCUR_UPDATABLE);
	
		
		//ResultSet rs = null;
		
		//rs = stmt.executeQuery("SELECT * FROM PUBLIC.TESTE1");

		//while (rs.next()) {
		//	System.out.println(rs.getInt(1));
		//}

		 
		 
	}

}
