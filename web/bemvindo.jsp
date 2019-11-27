<%--
  Created by IntelliJ IDEA.
  User: RYZEN2400G
  Date: 25/11/2019
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <% String mensagem = "Hello JSP"; %>
    <% String nome = "Richard";%>
    <%= mensagem %><br/>
    <a href="WEB-INF/jsp/adiciona-contato.jsp">
        <button type="button">
        Adicionar Contato
        </button>
    </a><br/>

    <a href="digita-idade.jsp">
        <button type="button">
            Digitar idade
        </button>
    </a>
    <br/>

    <a href="taglibs.jsp">
        <button type="button">
            Taglibs
        </button>
    </a>
    <br/>

    <a href="mvc?logica=ListaContatosLogic">
        <button type="button">
            Lista de Contatos
        </button>
    </a>

    <br/>
    <br/>


    <%System.out.println("Tudo foi executado");%>
</html>
