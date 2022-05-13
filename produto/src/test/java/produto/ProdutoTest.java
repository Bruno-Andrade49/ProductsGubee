package produto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import classesDAO.ProdutoDAO;
import conectaPg.Conecta;

public class ProdutoTest { 
	
	@Test
	public void deveRealizarListagem() {
		ProdutoDAO produtoDAO = null;
		
		
		boolean var = true;
		
	
		try {
			produtoDAO = new ProdutoDAO();
			produtoDAO.listarProduto();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			var = false;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			var = false;
			
		}
		
		
		assertTrue(var);
		
	}
	
	@Test
	public void testaConexao() {
		
		boolean var = true;
		
		try {
			Conecta.criarConexao();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			var = false;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			var = false;
		}
		
		
		assertTrue(var);
	
	}
	
	
	
	
	

}
