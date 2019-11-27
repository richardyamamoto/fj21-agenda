package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChamaAlteraContatoLogic implements Logica{


    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        return "WEB-INF/jsp/altera-contato.jsp";
    }
}
