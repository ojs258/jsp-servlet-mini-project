<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <title>뉴스 목록</title>
</head>
<body>
<div class="container w-75 mt-5 mx-auto">
    <h2>뉴스 목록</h2>
    <hr>
    <ul class="list-group">
        <c:forEach var="news" items="${newslist}" varStatus="status">
            <li class="list-group-item list-group-item-action d-flex justify-content-between align-item-center">
                <a href="news.nhn?action=getNews&aid=${news.aid}" class="text-decoration-none">
                    [${status.count}] ${news.title}, ${news.date} </a>
                <a href="news.nhn?action=deleteNews&aid=${news.aid}" class="text-decoration-none">
                    <span class="badge bg-secondary">&times;</span>
                </a>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
