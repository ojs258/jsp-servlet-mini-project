<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="kr">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>뉴스 등록</title>
</head>
<body>
<div class="container w-75 mt-5 mx-auto">
    <h2> 뉴스 등록</h2>
    <hr>
    <c:if test="${error != null}">
        <div class="alert alert-danger" role="alert">${error}</div>
    </c:if>

    <div class="card card-body">
        <form method="post" action="/add" enctype="multipart/form-data">
            <label class="form-label">제목</label>
            <input type="text" name="title" class="form-control">
            <label class="form-label">이미지</label>
            <input type="file" name="file" class="form-control">
            <label class="form-label">기사내용</label>
            <textarea cols="50" rows="5" name="content" class="form-control"></textarea>
            <button type="submit" class="btn btn-success mt-3">저장</button>
        </form>
    </div>
    <a href="javascript:history.back()" class="btn btn-primary"> << BACK </a>
</div>
</body>
</html>