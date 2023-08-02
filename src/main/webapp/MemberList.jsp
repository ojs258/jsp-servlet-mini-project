<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/memberList.css" />
    <title>Title</title>
</head>
<style>

</style>
<body>
<div>
    <h1>회원 목록</h1>
    <table>
        <th>회원 아이디</th>
        <th>회원 이름</th>
        <c:forEach var="MemberDTO" items="${MemberDTOS}">
        <tr>
            <td>${MemberDTO.name}</td>
            <td>${MemberDTO.id}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
