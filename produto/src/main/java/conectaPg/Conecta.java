package conectaPg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Classe de conexão com o Banco de Dados via JDBC
public class Conecta {
	static final String URL = "jdbc:postgresql://localhost:5432/gubbeProducts";
	static final String USER = "postgres";
	static final String PASS = "1234567";
	
	//Método de conexão
	public static Connection criarConexao() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection conecta = DriverManager.getConnection(URL, USER, PASS);
		
		if(conecta != null) {
			System.out.println("Conectado!!");
			return conecta;
		}
		System.out.println("N�o conectado");
		return null;
	}
}
