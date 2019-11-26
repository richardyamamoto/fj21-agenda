<%--
  Created by IntelliJ IDEA.
  User: RYZEN2400G
  Date: 26/11/2019
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Taglibs</title>
</head>
<body>

    <table>

    <jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDao"/>
    <c:forEach var="contato" items="${dao.lista}">
        <tr>
            <td>${contato.nome}</td>
            <td>${contato.email}</td>
            <td>${contato.endereco}</td>
            <td>${contato.dataNascimento}</td>
        </tr>
    </c:forEach>
    </table>

</body>
</html>
