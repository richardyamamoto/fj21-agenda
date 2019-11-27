<%--
  Created by IntelliJ IDEA.
  User: RYZEN2400G
  Date: 25/11/2019
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Contatos</title>
</head>
<body>
    <%@
        page import="java.util.*,
        br.com.caelum.dao.*,
        br.com.caelum.modelo.*"
    %>
    <%@ page import="java.text.SimpleDateFormat" %>

    <%
        ContatoDao dao = new ContatoDao();
        List<Contato> contatos = dao.getLista();
        for(Contato contato : contatos){
    %>

    <table>
        <tr>
            <td>Nome: <%=contato.getNome()%></td>
        </tr>
        <tr>
            <td>E-mail: <%=contato.getEmail()%></td>
        </tr>
        <tr>
            <td>Endereço: <%=contato.getEndereco()%></td>
        </tr>
        <tr>
            <td>Data de Nascimento: <%contato.getDataNascimento();%></td>
        </tr>
        <tr>
            <td> </td>
        </tr>
    </table>

    <%
        }
    %>

</body>
</html>
