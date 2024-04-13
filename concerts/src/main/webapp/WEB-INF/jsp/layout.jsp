<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
     <link rel="stylesheet" href="/App.css">
    <title>Main CRUD</title>

</head>
<style>
 body {
   background: var(--clr-grey-10);
 }
 .section {
     padding: 2rem 0;
 }
 .btn {
   text-align: center;
   display: block;
   margin: 0 auto;
   margin-bottom: 1.5rem;
   width:250px;
 }
.btn-end{
margin-top: 3.5rem;
}
.section-center {
    padding: 0rem 0;
}
</style>

<body>
     <section class="section services" id="services">
            <div class="section-title">
                <h2 style="text-align: center;"><span>Разделы</span></h2>
            </div>
            <div class="section-center services-center">
<a href="/viewConcertList" class="btn" >Концерты</a>
            </div>
<div class="section-center services-center">
<a href="/viewArtistList" class="btn" >Артисты</a>
            </div>
<div class="section-center services-center">
<a href="/viewTechnicalRiderList" class="btn" >Технические райдеры</a>
            </div>
<div class="section-center services-center">
<a href="/viewSceneList" class="btn" >Сцены</a>
            </div>
<div class="section-center services-center">
<a href="/viewTicketList" class="btn" >Билеты</a>
            </div>
<%--<div class="section-center services-center">
<a href="/viewArtistList" class="btn" >Работники</a>
            </div>
<div class="section-center services-center">
<a href="/viewArtistList" class="btn" >Задействованные работники</a>
            </div>
<div class="section-center services-center">
<a href="/viewArtistList" class="btn" >Рекламные предложения</a>
            </div>
<div class="section-center services-center">
<a href="/viewArtistList" class="btn" >Рекламные кампании</a>
            </div>--%>
<div class="section-center services-center btn-end">
<a href="/main" class="btn" >На главную</a>
            </div>
        </section>
</body>
</html>
