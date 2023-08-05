<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <link rel="stylesheet" href="css/form.css" />
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
<div class="container">
    <form method="post" action="/login">
        <h2>로그인</h2>
        <c:if test="${error != null}">
            <div class="alert">${error}</div>
        </c:if>
        <div class="tag">
            <label>이메일 : </label>
            <input type="email" name="email"><br>
            <label>비밀번호 : </label>
            <input type="text" name="pw"><br>
        </div>
        <p style="font-size: 17px">${msg}</p>
        <button type="submit">로그인</button>
    </form>
</div>
</body>
</html>