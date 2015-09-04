import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Receptor")
public class BDservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BDservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		User  usu = new User();
		usu.setNome(request.getParameter("nome"));
		usu.setEmail(request.getParameter("Email"));
		usu.setSenha(request.getParameter("senha"));
		DAOuser usuDao = new DAOuser();
		

	    if (request.getParameter("nome") == null) {
	   
	   out.println("<html>");
	         out.println("<body>");
	         out.println("<h1> " +usuDao.Verificar(usu));    
	         out.println("</body>");
	         out.println("</html>");
	    }
	    else{
	     usuDao.Cadastrar(usu);
	     out.println("<html>");
	          out.println("<body>");
	          out.println("<h1> USUÁRIO " +usu.getEmail()+" CADASTRADO COM SUCESSO (y)!");    
	          out.println("</body>");
	          out.println("</html>"); 	         
	     
	    }
	  	  
	  
	 }

	}