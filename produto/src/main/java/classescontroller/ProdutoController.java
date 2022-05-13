package classescontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import com.google.gson.Gson;

import classesDAO.ProdutoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProdutoController", urlPatterns = "/listagem")
public class ProdutoController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	Connection conn;
	
	Gson gson = new Gson();	
	
	ProdutoDAO produtoDAO = null;
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.addHeader("Access-Control-Allow-Origin", "*");
	    resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
	    resp.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
	    resp.addHeader("Access-Control-Max-Age", "1728000");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		resp.setStatus(200);
				
		try {
			produtoDAO = new ProdutoDAO();
			
			PrintWriter pw = resp.getWriter();
			pw.print(gson.toJson(produtoDAO.listarProduto()));
			pw.flush();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
