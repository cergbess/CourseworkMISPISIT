<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <<meta charset="UTF-8">
    <link rel="stylesheet" href="/App.css">
    <title>View Artist List</title>

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
          border-color: var(--clr-primary-5); /* Измените цвет рамки на цвет вашего фона */
        }
        .btn-danger {
          border-color: var(--clr-primary-5); /* Измените цвет рамки на цвет вашего фона */
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
        margin-left: 0 !important; /* Устанавливаем отступ на 0 */
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
<h1 class="p-3"> Артисты </h1>
<form action="/getArtistsByFullName" method="GET" class="form-inline">
        <div class="form-group mx-sm-3 mb-2">
            <label for="fullname" class="sr-only">Полное ися</label>
            <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Введите имя артиста">
        </div>
        <button type="submit" class="btn btn-get">Получить артистов</button>
    </form>


<form:form>
<table class="table table-bordered">
<tr>
    <th>Id</th>
    <th>FullName</th>
    <th>ManagerFullName</th>
    <th>ContactInfo</th>
    <th>PopularityIndex</th>
    <th>FeeAmount</th>

    <c:forEach var="artist" items="${artists}">
    <tr>
        <td>${artist.id}</td>
        <td>${artist.fullName}</td>
        <td>${artist.managerFullName}</td>
        <td>${artist.contactInfo}</td>
        <td>${artist.popularityIndex}</td>
        <td>${artist.feeAmount}</td>
        <td>
            <button type="button" class="btn">
                <a href="/editArtist/${artist.id}">Редактировать</a>
            </button>
        </td>
        <td>
            <button type="button" class="btn">
                <a href="/deleteArtist/${artist.id}">Удалить</a>
            </button>
        </td>
    </tr>
    </c:forEach>

</tr>
</table>

</form:form>
  <a href="/AddArtist" class="btn btn-block">Добавить нового артиста</a>

        <div style="display: flex; justify-content: center;margin-top: 20px;">
            <ul style="list-style: none;">
                <li><a href="/layout" class="btn btn-end btn-block">Назад</a></li>
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
          } else if (msg == "Save Success") {
              toastr["success"]("Артист успешно добавлен ", "", { "progressBarColor": "#007bff" });
          } else if (msg == "Delete Success") {
              toastr["success"]("Артист успешно удалён", "", { "progressBarColor": "#007bff" });
          } else if (msg == "Delete Failure") {
              toastr["error"]("Произошла ошибка, артист не был удален", "", { "progressBarColor": "#dc3545" });
          } else if (msg == "Edit Success") {
              toastr["success"]("Данные артиста успешно изменены", "", { "progressBarColor": "#007bff" });
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