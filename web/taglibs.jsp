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

    <jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDao"/>
        <table border="1">
            <c:forEach varStatus="id" var="contato" items="${dao.lista}">
                <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
                    <td>${contato.nome}</td>
                    <td>
<%--                        Dois ifs--%>
<%--                        <c:if test="${not empty contato.email}">--%>
<%--                            <a href="mailto:${contato.email}">${contato.email}</a>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${empty contato.email}">--%>
<%--                            E-mail não informado--%>
<%--                        </c:if>--%>
<%--                        Switch case--%>
                        <c:choose>
                            <c:when test="${not empty contato.email}">
                                <a href="mailto:${contato.email}">${contato.email}</a>
                            </c:when>
                            <c:otherwise>
                                E-mail não informado
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${contato.endereco}</td>
                    <td>${contato.dataNascimento}</td>
                </tr>
            </c:forEach>
        </table>

</body>
</html>
