<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="./css/memberList.css"/>
    <title>뉴스 목록</title>
</head>
<style>

</style>
<body>
<div>
    <h1>회원 목록</h1>
    <table>
        <th>회원 아이디</th>
        <th>회원 이름</th>
        <c:forEach var="members" items="${members}">
        <tr>
            <td>${members.id}</td>
            <td>${members.name}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
