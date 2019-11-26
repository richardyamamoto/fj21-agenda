<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="data"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Adiciona Contato</title>
</head>
<body>

    <form action="AdicionaContatoLogic" method="get">
        Nome: <input type="text" name="nome"/> <br/>
        E-mail: <input type="text" name="email"/> <br/>
        Endereço: <input type="text" name="endereco"/> <br/>
        Data de Nascimento: <input type="text" name="dataNascimento"/> <br/>
        <br/>
        <button type="submit">Gravar</button>
    </form>
</body>
</html>