<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Edit Concert</title>
 <link rel="stylesheet" href="/App.css">
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
          margin-left: 0.5rem;
        }
        .btn-danger {
          border-color: var(--clr-primary-5);
        }
.form-group {
padding: 0rem 0rem;
    margin-bottom: 0rem;
}
.btn-end{
width:170px;
}
.p-3 {
    padding: 0rem !important;
    margin-top: 1rem;
}

.form-inline .form-control {
    display: inline-block;
    width: 300px;
    vertical-align: middle;
}
.col-md-2 {
    padding-right: 1rem;
}
.btn-success {
    border-color: var(--clr-primary);
    margin-left: 0rem;
}
.btn-success:hover {
 border-color: background var(--clr-primary);
    background-color: var(--clr-primary);
    margin-left: 0rem;
}
    </style>
</head>
<body>

    <div class="container">

        <h1 class="p-3"> Редактировать концерт </h1>

        <form action="/editSaveConcert" method="post">

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="id"></label>
                    <div class="col-md-6">
                        <input type="hidden" name="id" id="id" class="form-control input-sm" value="${concert.id}" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="artistId">Артист</label>
                    <div class="col-md-6">
                        <input type="text" name="artistId" id="artistId" class="form-control input-sm" value="${concert.artistId}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="sceneId">Сцена</label>
                    <div class="col-md-6">
                        <input type="text" name="sceneId" id="sceneId" class="form-control input-sm" value="${concert.sceneId}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="concertName">Название</label>
                    <div class="col-md-6">
                        <input type="text" name="concertName" id="concertName" class="form-control input-sm" value="${concert.concertName}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="concertDateTime">Дата проведения</label>
                    <div class="col-md-6">
                        <input type="datetime-local" name="concertDateTime" id="concertDateTime" class="form-control input-sm" value="${concert.concertDateTime}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="audienceCount">Количество зрителей</label>
                    <div class="col-md-6">
                        <input type="number" name="audienceCount" id="audienceCount" class="form-control input-sm" value="${concert.audienceCount}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <%--@declare id="passed"--%><label class="col-md-3" for="passed">Прошедший</label>
                    <div class="col-md-6">
                        <select name="passed" class="form-control input-sm">
                            <option value="true" <c:if test="${passed.passed == 'true'}">selected</c:if>>true</option>
                            <option value="false" <c:if test="${concert.passed == 'false'}">selected</c:if>>false</option>
                        </select>
                    </div>
                </div>
            </div>

            <div class="row p-2">
                <div class="col-md-2">
                    <button type="submit" value="Register" class="btn btn-success">Сохранить</button>
                </div>
            </div>

        </form>

    </div>

    <script th:inline="javascript">
                   window.onload = function() {

                       var msg = "${message}";
                       console.log(msg);
                       if (msg == "Edit Failure") {
           				Command: toastr["error"]("Something went wrong with the edit.")
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
                           }
           	    }
               </script>


</body>
</html>