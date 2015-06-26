package test.java;

import java.sql.SQLException;

import junit.framework.TestCase;
import main.java.Conecta;

import org.junit.Test;

public class TestaConexao extends TestCase  {

	@Test
	public void testaConexao() throws SQLException {

		Conecta con = new Conecta();
		
		boolean resultado = con.conexao();
		
		assertEquals(true,resultado);
		
	}

}
