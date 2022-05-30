package classesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classesBean.Produto;
import classesBean.Stack;
import classesBean.TargetMarket;
import conectaPg.Conecta;

public class ProdutoDAO {

	private Connection con;

	public ProdutoDAO() throws SQLException, ClassNotFoundException {

		con = Conecta.criarConexao();

	}

	//Método de busca ao banco e listagem do produto via JDBC
	public List<Produto> listarProduto() {

		String sql = "SELECT * FROM produtos order by productName";

		List<Produto> lista = new ArrayList<Produto>();
		List<TargetMarket> listaTargetMarkets = new ArrayList<TargetMarket>();
		List<Stack> listaStacks = new ArrayList<Stack>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {

				Produto produto = new Produto();

				Stack stack = new Stack();

				TargetMarket targetMarket = new TargetMarket();

				produto.setProductName(resultados.getString("productName").toUpperCase());
				produto.setDescription(resultados.getString("description").toUpperCase());
				
				

				
				// Relacionamento TargetMarket
				PreparedStatement preparadorSql2 = con.prepareStatement("SELECT * FROM TargetMarket WHERE productfk = ?");
				
				preparadorSql2.setInt(1, resultados.getInt("idtargetmarket"));
				
				ResultSet resultadoTargetMarket = preparadorSql2.executeQuery();

				
				while (resultadoTargetMarket.next()) {
					System.out.println(resultadoTargetMarket.getString("productfk"));
					System.out.println(resultados.getString("idtargetmarket"));
					
					if(resultados.getInt("idtargetmarket") == resultadoTargetMarket.getInt("productfk")) {
						
						targetMarket = new TargetMarket();

						targetMarket.setId(resultadoTargetMarket.getInt("targetmarketid"));
						targetMarket.setTargetMarkets(resultadoTargetMarket.getString("targetMarket"));
						targetMarket.setProductfk(resultadoTargetMarket.getInt("productfk"));

						
						// Relaciona o targetMarket com Produto
						listaTargetMarkets.add(targetMarket);
					} else {
						System.out.println("Não faz parte");
					}
				}

				produto.setTargetMarket(listaTargetMarkets);


				// Relacionamento Stack
				PreparedStatement preparadorSql3 = con.prepareStatement("SELECT * FROM Stack WHERE stackid = ?");

				preparadorSql3.setInt(1, stack.getId());

				ResultSet resultadoStack = preparadorSql3.executeQuery();

				while (resultadoStack.next()) {

					stack = new Stack();
					stack.setId(resultadoStack.getInt("stackid"));
					stack.setStacks(resultadoStack.getString("stack"));
					stack.setProductfk(resultadoStack.getInt("productId"));

					// Relaciona a lista de stacks com Produto
					listaStacks.add(stack);
				}

				produto.setStack(listaStacks);
				lista.add(produto);

				/*
				 * List<Integer> listaNum = new ArrayList<Integer>(); listaNum.add(1);
				 * listaNum.add(2); listaNum.add(3);
				 * 
				 * 
				 * Exemplo do uso de Stremas e Expressões Lambda List<Integer> listaNewNumb =
				 * listaNum.stream().map((i) -> i * 2).collect(Collectors.toList());
				 * listaNewNumb.forEach((i) -> System.out.println(i));
				 */

			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

		return lista;
	}

}
