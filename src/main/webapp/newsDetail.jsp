<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
    <div class="container w-75 mt-5 mx-auto">
        <h2>${detailNews.title}</h2>
        <hr>
        <div class="card w-75 mx-auto">
            <img class="card-img-top" src="${detailNews.img}">
            <div class="card-body">
                <h4 class="card-title">Date: ${detailNews.date}</h4>
                <p class="card-text">Content: ${detailNews.content}</p>
            </div>
        </div>
        <hr>
        <a href="javascript:history.back()" class="btn btn-primary"> << BACK </a>
    </div>
</body>
</html>
