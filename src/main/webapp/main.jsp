<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="./css/index.css" />
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>메인 페이지</h1>
    <div>${name}님 환영합니다. 아래 메뉴를 이용해 주세요.</div>
    <div class="button">
        <a methods="get" href="/newsForm.jsp">뉴스등록</a>
    </div>
    <div class="button">
        <a methods="get" href="/news.nhn">뉴스목록</a>
    </div>
    <div class="button">
        <a methods="get" href="/logout">로그아웃</a>
    </div>
    <div class="button">
        <a methods="get" href="/withdraw">회원탈퇴</a>
    </div>
</div>
</body>
</html>
