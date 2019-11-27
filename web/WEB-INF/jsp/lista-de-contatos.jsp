<%--
  Created by IntelliJ IDEA.
  User: RYZEN2400G
  Date: 26/11/2019
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Lista de Contatos</title>
</head>
<body>
<c:import url="../../components/header.jsp"/>
    <table border="1">
        <c:forEach varStatus="index" var="contato" items="${contatos}">
            <tbody>
                <tr bgcolor="#${index.count % 2 == 0 ? 'eee': 'fff'}">
                    <td>${contato.id}</td>
                    <td>${contato.nome}</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty contato.email}">${contato.email}</c:when>
                            <c:otherwise>E-mail não informado</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${contato.endereco}</td>
                    <td>
                        <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>
                        <a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
                        <a href="mvc?logica=ChamaAlteraContatoLogic&id=${contato.id}">Editar</a>
                    </td>
                </tr>
            </tbody>
        </c:forEach>
    </table>
<a href="mvc?logica=ChamaAdicionaContatoLogic"><button>Adicionar Contato</button></a>
<c:import url="../../components/footer.jsp"/>
</body>
</html>
