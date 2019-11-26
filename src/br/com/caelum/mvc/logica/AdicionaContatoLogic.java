package br.com.caelum.mvc.logica;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AdicionaContatoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ContatoDao dao = new ContatoDao();
        Contato contato = new Contato();

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");
        String dataNascimento = req.getParameter("dataNascimento");
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        String dataEmTexto =  dataNascimento;

//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        Date dataFormatada = formatter.parse(dataEmTexto);
//        Calendar calender = Calendar.getInstance();
//        calender.setTime(dataFormatada);
//        System.out.println(dataFormatada);
        //contato.setDataNascimento(calender);
        System.out.println(nome);
        return "/contato-adicionado.jsp";
    }
}
