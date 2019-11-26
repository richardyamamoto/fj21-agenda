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
    <a href="adiciona-contato.html">
        <button type="button">
        Adicionar Contato
        </button>
    </a>
    <a href="digita-idade.jsp">
        <button type="button">
            Digitar idade
        </button>
    </a>
    <%= mensagem %>
    <br/>
    <%System.out.println("Tudo foi executado");%>
</html>
