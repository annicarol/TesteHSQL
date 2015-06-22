import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conecta {

	public static void main(String[] args) throws SQLException {

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (Exception e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;
		}

		
		// abre a conexão
		Connection c = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/", "SA", "");

		Statement stmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
	
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM PUBLIC.TESTE1");
		// rs will be scrollable, will not show changes made by others,
		// and will be updatable

		while (rs.next()) {
			System.out.println(rs.getInt(1));
		}
			
		
		// fecha a conexão
		 c = DriverManager.getConnection(
		         "jdbc:hsqldb:file:/opt/db/testdb;shutdown=true", "SA", "");

	}

}
