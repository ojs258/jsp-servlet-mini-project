<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <link rel="stylesheet" href="./css/form.css" />
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<script>
    window.onbeforeunload = function (){
        <c:if test="${null != msg}">
            alert(${msg});
        </c:if>
    }
</script>
<body onload="error()">
<div class="container">
    <form method="post" action="/join">
        <h2>회원 가입</h2>
        <c:if test="${error != null}">
            <div class="alert">${error}</div>
        </c:if>
        <div class="tag">
            <label>이메일 : </label> <input name="email" type="text"><br>
            <label>비밀번호 : </label> <input name="pw" type="text"><br>
            <label>이름 :</label> <input name="name" type="text"><br>

        </div>
        <button type="submit">회원 가입</button>
        <button type="reset">초기화</button>
    </form>
</div>
</body>
</html>