package br.com.caelum.mvc.logica;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AlteraContatoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ContatoDao dao = new ContatoDao();
        List<Contato> contatos = dao.getLista();
        req.setAttribute("contatos", contatos);
        return "/WEB_INF/jsp/altera-contato.jsp";
    }
}
