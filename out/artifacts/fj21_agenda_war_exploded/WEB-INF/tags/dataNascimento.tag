<html>
<head>
<script
    src="https://code.jquery.com/jquery-3.4.1.js"
    integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
    crossorigin="anonymous">
</script>
</head>
<body>
    <%@ attribute name="id" required="true" %>
    <input id="${id}" name="${id}">
<script>
        $("#dataNascimento").dataPicker();
</script>
</body>
</html>
