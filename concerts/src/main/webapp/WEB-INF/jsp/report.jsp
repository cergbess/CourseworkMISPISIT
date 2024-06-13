<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <<meta charset="UTF-8">
    <link rel="stylesheet" href="/App.css">
    <title>View Report List</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
        .btn {
            background: var(--clr-primary);
            color: white;
        }
        .btn-success {
            border-color: var(--clr-primary-5);
        }
        .btn-danger {
            border-color: var(--clr-primary-5);
        }

        .btn-end{
            width:170px;
        }

        .form-inline .form-control {
            display: inline-block;
            width: 400px;
            vertical-align: middle;
        }
        @media (min-width: 576px) {
            .ml-sm-3, .mx-sm-3 {
                margin-left: 0 !important;
            }
            .form-group {
                padding: 0rem 0rem;
            }
            .form-control {
                margin-bottom: 0rem;
            }
            .btn-get {
                margin-bottom: 0.5rem;
            }}

    </style>

</head>
<body>

<div class="container">
    <h1 class="p-3"> Отчет </h1>
    <form action="/getReportByFullName" method="GET" class="form-inline">
        <div class="form-group mx-sm-3 mb-2">
            <label for="concertname" class="sr-only">Полное ися</label>
            <input type="text" class="form-control" id="concertname" name="concertname" placeholder="Введите название концерта">
        </div>
        <button type="submit" class="btn btn-get">Получить концерты</button>
    </form>



    <form:form>
        <table class="table table-bordered">
            <tr>
                <th>Номер</th>
                <th>Артист</th>
                <th>Сцена</th>
                <th>Название</th>
                <th>Дата проведения</th>
                <th>Количество зрителей</th>
                <th>Прошедший</th>

                <c:forEach var="concert" items="${concerts}">
            <tr>
                <td>${concert.id}</td>
                <td>${concert.artistId}</td>
                <td>${concert.sceneId}</td>
                <td>${concert.concertName}</td>
                <td>${concert.concertDateTime}</td>
                <td>${concert.audienceCount}</td>
                <td>${concert.passed}</td>
            </c:forEach>

            </tr>
        </table>

        <table class="table table-bordered">
            <tr>
                <th>Номер</th>
                <th>Концерт</th>
                <th>Категория</th>
                <th>Цена</th>
                <th>Всего</th>
                <th>Продано</th>

                <c:forEach var="ticket" items="${tickets}">
            <tr>
                <td>${ticket.id}</td>
                <td>${ticket.concertId}</td>
                <td>${ticket.ticketCategory}</td>
                <td>${ticket.ticketPrice}</td>
                <td>${ticket.totalTicketsCount}</td>
                <td>${ticket.soldTicketsCount}</td>
            </tr>
            </c:forEach>

            </tr>
        </table>

    </form:form>

    <div style="display: flex; justify-content: center;margin-top: 20px;">
        <ul style="list-style: none;">
            <li><a href="/viewConcertList" class="btn btn-end btn-block">Назад</a></li>
        </ul>
    </div>
    <div style="display: flex; justify-content: center;">
        <ul style="list-style: none;">
            <li><a href="/main" class="btn btn-end btn-block">На главную</a></li>
        </ul>
    </div>

</div>
<script th:inline="javascript">
    window.onload = function() {
        var msg = "${message}";
        console.log(msg);
        if (msg == "Get Success") {
            toastr["success"]("Данные успешно получены ", "", { "progressBarColor": "#007bff" });
        } else if (msg == "Get Failure") {
            toastr["error"]("Ошибка при получении данных", "", { "progressBarColor": "#dc3545" });
        }

        toastr.options = {
            "closeButton": true,
            "debug": false,
            "newestOnTop": false,
            "progressBar": true,
            "positionClass": "toast-top-right",
            "preventDuplicates": false,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        };
    };
</script>
</body>

</html>