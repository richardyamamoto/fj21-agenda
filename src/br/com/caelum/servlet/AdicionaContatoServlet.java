package br.com.caelum.servlet;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        String dataEmTexto = req.getParameter("dataNascimento");
        Calendar dataNascimento = null;

        try{
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(data);
        }catch(ParseException err) {
            System.out.println("Erro na conversão da data");
        }

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);
        contato.setDataNascimento(dataNascimento);

        ContatoDao dao = new ContatoDao();
        dao.adiciona(contato);

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h2> Nome: " + contato.getNome() +  " adicionado com sucesso!</h2><br/>");
        out.println("<h2> Endereco: " + contato.getEndereco() +  " adicionado com sucesso!</h2><br/>");
        out.println("<h2> E-mail: " + contato.getEmail() +  " adicionado com sucesso!</h2><br/>");
        out.println("</body>");
        out.println("</html>");
    }
}
