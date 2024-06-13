<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Edit Ticket</title>
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

        <h1 class="p-3"> Редактировать билеты </h1>

        <form action="/editSaveTicket" method="post">

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="id"></label>
                    <div class="col-md-6">
                        <input type="hidden" name="id" id="id" class="form-control input-sm" value="${ticket.id}" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="concertId">Концерт</label>
                    <div class="col-md-6">
                        <input type="text" name="concertId" id="concertId" class="form-control input-sm" value="${ticket.concertId}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <%--@declare id="ticketcategory"--%><label class="col-md-3" for="ticketCategory">Категория</label>
                    <div class="col-md-6">
                        <select name="ticketCategory" class="form-control input-sm">
                            <option value="VIP" <c:if test="${ticket.ticketCategory == 'VIP'}">selected</c:if>>VIP</option>
                            <option value="Standart" <c:if test="${ticket.ticketCategory == 'Standart'}">selected</c:if>>Standart</option>
                            <option value="Dance Floor" <c:if test="${ticket.ticketCategory == 'Dance Floor'}">selected</c:if>>Dance Floor</option>
                        </select>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="ticketPrice">Цена</label>
                    <div class="col-md-6">
                        <input type="number" name="ticketPrice" id="ticketPrice" class="form-control input-sm" value="${ticket.ticketPrice}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="totalTicketsCount">Всего</label>
                    <div class="col-md-6">
                        <input type="number" name="totalTicketsCount" id="totalTicketsCount" class="form-control input-sm" value="${ticket.totalTicketsCount}" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3" for="soldTicketsCount">Продано</label>
                    <div class="col-md-6">
                        <input type="number" name="soldTicketsCount" id="soldTicketsCount" class="form-control input-sm" value="${ticket.soldTicketsCount}" required="required" />
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