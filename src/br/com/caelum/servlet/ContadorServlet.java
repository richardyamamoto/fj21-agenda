package br.com.caelum.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/contator")
public class ContadorServlet extends HttpServlet {
    private int contador = 0;
    @Override
    public void init() throws ServletException {
        super.init();
        log("Inicia Servlet");
    }

    @Override
    public void destroy() {
        super.destroy();
        log("Finaliza Servlet");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        contador++;

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Contador agora é: " + contador);
        out.println("</body>");
        out.println("</html>");
    }
}
