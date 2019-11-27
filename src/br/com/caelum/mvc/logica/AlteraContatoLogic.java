package br.com.caelum.mvc.logica;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AlteraContatoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ContatoDao dao = new ContatoDao();
        Contato contato = new Contato();
        Long id = Long.parseLong(req.getParameter("id"));

        contato.setId(id);
        contato.setNome(req.getParameter("nome"));
        contato.setEmail(req.getParameter("email"));
        contato.setEndereco(req.getParameter("endereco"));
        String dataEmTexto = req.getParameter("dataNascimento");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = formatter.parse(dataEmTexto);
        Calendar calender = Calendar.getInstance();
        calender.setTime(dataFormatada);
        contato.setDataNascimento(calender);

        dao.altera(contato);

        return "mvc?logica=ListaContatosLogic";
    }
}
