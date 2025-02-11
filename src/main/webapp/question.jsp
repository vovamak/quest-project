
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Вопрос</title>
</head>
<body>
    <h1>${question.text}</h1>
    <form action="/game" method="post">
        <c:forEach items="${question.answers}" var="answer" varStatus="loop">
            <input type="radio" name="answer" value="${loop.index}" required> ${answer}<br>
        </c:forEach>
        <button type="submit">Ответить</button>
    </form>

    <form action="/stop" method="post">
        <button type="submit">Остановить игру</button>
    </form>
    <div style="position: fixed; bottom: 10px; left: 10px; border: 1px solid black; padding: 5px;">
        Игрок: ${game.playerName}
        IP: ${ipAddress} <br>
        Сыграно игр: ${gamesPlayed}
    </div>
</body>
</html>
