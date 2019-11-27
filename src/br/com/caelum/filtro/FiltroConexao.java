package br.com.caelum.filtro;

import br.com.caelum.factory.ConnectionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class FiltroConexao implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            Connection connection = new ConnectionFactory().getConnection();
            servletRequest.setAttribute("conexao", connection);
            filterChain.doFilter(servletRequest, servletResponse);
            connection.close();
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
