<%--
  Created by IntelliJ IDEA.
  User: RYZEN2400G
  Date: 26/11/2019
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Alterar Contato</title>
</head>
<body>
    <c:import url="../../components/header.jsp"/>
    <form action="mvc?logica=AlteraContatoLogic&id=${param.id}" method="post">
        Nome: <input type="text" name="nome" value="${contato.nome}"/><br/>
        Email: <input type="text" name="email"/><br/>
        Endereço: <input type="text" name="endereco"/><br/>
        Data de Nascimento: <input type="text" name="dataNascimento"/><br/>
        <br/>
        <button type="submit">Atualizar</button>
    </form>
    <c:import url="../../components/footer.jsp"/>
</body>
</html>
