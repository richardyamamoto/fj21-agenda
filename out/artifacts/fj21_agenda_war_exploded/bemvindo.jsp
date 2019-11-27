<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>
        html {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            width:450px;
            margin: 50px auto;
        }
        div {
            display: flex;
            flex-direction: row;
            background: #eeeeee;
            height: 100px;
            align-items: center;
            justify-content: space-around;
            padding: 25px;
        }
        div>a {
            height: 50px;
        }
        .btn {
            border: none;
            border-radius: 5px;
            cursor: pointer;
            background: #fff;
            padding: 10px;
            box-shadow: 1px 1px 10px;
        }


    </style>
</head>
<body>
    <c:import url="components/header.jsp"/>
    <% String mensagem = "Hello JSP"; %>
    <% String nome = "Richard";%>
    <%= mensagem %><br/>
    <div>
        <a href="mvc?logica=ChamaAdicionaContatoLogic">
            <button class="btn" type="button">
            Adicionar Contato
            </button>
        </a>

        <a href="mvc?logica=ListaContatosLogic">
            <button class="btn" type="button">
                Lista de Contatos
            </button>
        </a>
    </div>

    <br/>
    <br/>


    <%System.out.println("Tudo foi executado");%>
    <c:import url="components/footer.jsp"/>
</html>
