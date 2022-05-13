package classesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import classesBean.Produto;
import classesServices.ProdutoService;
import conectaPg.Conecta;

public class ProdutoDAO implements ProdutoService{

	private Connection con;

	public ProdutoDAO() throws SQLException, ClassNotFoundException {

		con = Conecta.criarConexao();

	}

	public List<Produto> listarProduto() {

		String sql = "SELECT * FROM produtos order by productName";

		List<Produto> lista = new ArrayList<Produto>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();

			while (resultados.next()) {

				Produto produto = new Produto();

				produto.setProductName(resultados.getString("productName").toUpperCase());
				produto.setDescription(resultados.getString("description").toUpperCase());
				produto.setTargetMarket(resultados.getString("targetMarket").toUpperCase());
				produto.setStack(resultados.getString("stack").toUpperCase());
				
				lista.add(produto);
				
				
				/*
				List<Integer> listaNum = new ArrayList<Integer>();
				listaNum.add(1);
				listaNum.add(2);
				listaNum.add(3);
				
				
				Exemplo do uso de Stremas e Expressões Lambda
				List<Integer> listaNewNumb = listaNum.stream().map((i) -> i * 2).collect(Collectors.toList());
				listaNewNumb.forEach((i) -> System.out.println(i));
				*/
				
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}

		return lista;
	}
	
}
