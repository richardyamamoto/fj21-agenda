package br.com.caelum.mvc.logica;

import br.com.caelum.dao.ContatoDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;

public class ListaContatosLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Connection connection = (Connection)req.getAttribute("conexao");
        ContatoDao dao = new ContatoDao(connection);
        List<?> contatos = dao.getLista();
        req.setAttribute("contatos", contatos);
        return "WEB-INF/jsp/lista-de-contatos.jsp";
    }
}
