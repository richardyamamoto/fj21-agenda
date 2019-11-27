<%--
  Created by IntelliJ IDEA.
  User: RYZEN2400G
  Date: 26/11/2019
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Taglibs</title>
</head>
<body>
<c:import url="../components/header.jsp"/>
    <jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDao"/>
        <table border="1">
            <c:forEach varStatus="index" var="contato" items="${dao.lista}">
                <tr bgcolor="#${index.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
                    <td>${contato.id}</td>
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
                    <td>
                        <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>
                        <a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
<footer>
    <c:import url="../components/footer.jsp"/>
</footer>
</body>
</html>
