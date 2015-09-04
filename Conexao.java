import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public  static Connection getConnection() {
		Connection con = null;
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(
	 "jdbc:mysql://localhost/user", "root", "");
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	     catch(ClassNotFoundException e){  
	            throw new RuntimeException(e);  
	        } 
	     return con;
	 }

}