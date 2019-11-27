package br.com.caelum.mvc.logica;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class RemoveContatoLogic implements Logica {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        long id = Long.parseLong(req.getParameter("id"));
        Contato contato = new Contato();
        contato.setId(id);
        System.out.println(contato.getId());
//        Recupera dos atributos o objeto da conexão;
        Connection connection = (Connection) req.getAttribute("conexao");
        ContatoDao dao = new ContatoDao(connection);
        dao.exclui(contato);
        System.out.println("Excluindo contato: " +  contato.getId());
        return "WEB-INF/jsp/operacao-sucesso.jsp";
    }
}
