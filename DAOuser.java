import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOuser {
	 private Connection con = Conexao.getConnection();
	 public void Cadastrar(User usuario){
		 
String sql = "insert into usuario (nome,email,senha)values (?,?,?)";

try {
	PreparedStatement stmt = con.prepareStatement(sql);

    stmt.setString(1,usuario.getNome());
    stmt.setString(2,usuario.getEmail());
    stmt.setString(3, usuario.getSenha());

    stmt.execute();
    stmt.close();
    System.out.println("Você foi cadastrado com sucesso!");
  } catch (SQLException e) {
    throw new RuntimeException(e);
   }

    }
 public String Verificar(User usuario){
  String userName = null;
  String senha  =  null;
  String sql = "select email,senha from usuario where senha = ?";
  try{
  PreparedStatement stmt = con.prepareStatement(sql);
  stmt.setString(1,usuario.getSenha());
  ResultSet us = stmt.executeQuery(); 
  if(us != null && us.next()){  
             userName = us.getString("email");
    senha = us.getString("senha");
  }
   
  us.close ();
  stmt.close ();
  con.close();
  }catch(Exception e){
  System.out.println("Exception is :"+e);
  }
  if (usuario.getEmail().equals(userName) && usuario.getSenha().equals(senha)){
   return ("Bem vindo, acesse detalalhes da sua comta! (y) "+usuario.getEmail());
  }
  else{
   return("Email ou senha incorretos, Tente Novamente");
  }
 }
 }