// Importar bibliotecas java necessárias.
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Estender a classe HttpServlet
public class Main extends HttpServlet {

   private String message;

   public void init() throws ServletException {
      // Do required initialization
      // message = "Exemplo de Microservice WebApp Java e Tomcat: src/main/java/Main.java";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      // Definir tipo de conteúdo de resposta
      response.setContentType("text/html");

      // Todo código para frontend aqui.
      /* PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>");
      */
   }
}
