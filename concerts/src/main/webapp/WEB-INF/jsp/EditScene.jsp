<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Edit Scene</title>
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

        <h1 class="p-3"> Редактировать сцену </h1>

        <form action="/editSaveScene" method="post">

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="id"></label>
                    <div class="col-md-6">
                        <input type="hidden" name="id" id="id" class="form-control input-sm" value="${scene.id}" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="sceneName">Название</label>
                    <div class="col-md-6">
                        <input type="text" name="sceneName" id="sceneName" class="form-control input-sm" value="${scene.sceneName}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="pricePerPerformance">Цена за выступление</label>
                    <div class="col-md-6">
                        <input type="number" name="pricePerPerformance" id="pricePerPerformance" class="form-control input-sm" value="${scene.pricePerPerformance}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="sceneSize">Размер сцены</label>
                    <div class="col-md-6">
                        <input type="text" name="sceneSize" id="sceneSize" class="form-control input-sm" value="${scene.sceneSize}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="audienceSeats">Количество мест</label>
                    <div class="col-md-6">
                        <input type="number" name="audienceSeats" id="audienceSeats" class="form-control input-sm" value="${scene.audienceSeats}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="lightingDevices">Световые устройства</label>
                    <div class="col-md-6">
                        <input type="number" name="lightingDevices" id="lightingDevices" class="form-control input-sm" value="${scene.lightingDevices}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="soundSystems">Звуковые системы</label>
                    <div class="col-md-6">
                        <input type="number" name="soundSystems" id="soundSystems" class="form-control input-sm" value="${scene.soundSystems}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="specialEffectsAndDecorations">Спецэффекты и декорации</label>
                    <div class="col-md-6">
                        <input type="text" name="specialEffectsAndDecorations" id="specialEffectsAndDecorations" class="form-control input-sm" value="${scene.specialEffectsAndDecorations}" required="required" />
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