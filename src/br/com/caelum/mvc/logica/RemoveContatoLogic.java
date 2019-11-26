package br.com.caelum.mvc.logica;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveContatoLogic implements Logica {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        long id = Long.parseLong(req.getParameter("id"));
        Contato contato = new Contato();
        contato.setId(id);
        System.out.println(contato.getId());
        ContatoDao dao = new ContatoDao();
        dao.exclui(contato);
        System.out.println("Excluindo contato: " +  contato.getId());
        return "mvc?logica=ListaContatosLogic";
    }
}
