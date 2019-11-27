package br.com.caelum.mvc.logica;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AdicionaContatoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Connection connection = (Connection)req.getAttribute("conexao");
        ContatoDao dao = new ContatoDao(connection);
        Contato contato = new Contato();

        String dataNascimento = req.getParameter("dataNascimento");
        contato.setNome(req.getParameter("nome"));
        contato.setEndereco(req.getParameter("endereco"));
        contato.setEmail(req.getParameter("email"));
        String dataEmTexto =  dataNascimento;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = formatter.parse(dataEmTexto);
        Calendar calender = Calendar.getInstance();
        calender.setTime(dataFormatada);
        contato.setDataNascimento(calender);

        dao.adiciona(contato);
        return "WEB-INF/jsp/operacao-sucesso.jsp";
    }
}
