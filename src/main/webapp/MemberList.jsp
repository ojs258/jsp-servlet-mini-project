<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/jsp.css" />
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <h1>회원 목록</h1>
    <table>
        <c:forEach var="member" items="${members}">
        <tr>
            <td><h2>${member.name}</h2></td>
            <td><h2>${member.id}</h2></td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
