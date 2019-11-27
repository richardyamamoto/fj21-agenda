package br.com.caelum.filtro;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long tempoInicial = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long tempoFinal = System.currentTimeMillis();
        String uri = ((HttpServletRequest)servletRequest).getRequestURI();
        String parametros = ((HttpServletRequest) servletRequest).getParameter("logica");
        System.out.println("Tempo da requisicao de " + uri + "?logica=" + parametros + " demorou (ms): "
                + (tempoFinal - tempoInicial));
    }
}
