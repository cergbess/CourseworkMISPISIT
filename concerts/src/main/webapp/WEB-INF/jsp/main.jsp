<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sergbess</title>
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="App.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>
<style>
.cerg{
margin:1rem 0;
color:var(--clr-primary);
font-family: var(--ff-secondary);
}
</style>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<span class="nav-btn" id="nav-btn" onclick="menuClick()">

</span>

<nav class="navbar" id="navbar">
    <div class="navbar-header">
        <span class="nav-close" id="nav-close" onclick="CloseClick()">

        </span>
    </div>
    <ul class="nav-items">
        <li><a href="#home" class="nav-link">На главную</a></li>
        <li><a href="#about" class="nav-link">О нас</a></li>
        <li><a href="#team" class="nav-link">Сотрудники</a></li>
        <li><a href="#services" class="nav-link">Услуги</a></li>
        <li><a href="#contacts" class="nav-link">Напишите нам</a></li>
    </ul>
</nav>

<header class="header" id="home">
    <div class="banner">
        <h2>Sergbess</h2>
        <h1>
            Мы организуем концерты
        </h1>
        <a href="/layout" class="btn banner-btn">Запустить систему</a>
    </div>
</header>
<div class="content-divider"></div>
  <section class="skills clearfix">
  <div class="cerg"><h2  style="text-align: center;">Наши принципы</h2></div>

      <article class="skill">
        <span class="skill-icon">
      <i class="fas fa-hand-peace"></i>
        </span>
        <h4 class="skill-title">Качество</h4>
        <p class="skill-text">
          Со времён "Русского Вудстока" и до наших дней, компания Sergbess занимается организацией концертов и представлений.
          За более чем 30 лет работы мы сделали возможными сотни выступлений различных артистов.
          Вы можете быть уверены в качестве наших услуг
        </p>
      </article>

      <article class="skill">
        <span class="skill-icon">
        <i class="fab fa-fort-awesome"></i>
        </span>
        <h4 class="skill-title">Безопасность</h4>
        <p class="skill-text">
          Мы хорошо осведомлены о проблеме безопасности в вопросе организации массовых мероприятий,
          поэтому гарантируем принятие всех  необходимых мер. Ваш концерт оставит только положительные эмоции
        </p>
      </article>

      <article class="skill">
        <span class="skill-icon">
         <i class="fas fa-money-bill-wave"></i>
        </span>
        <h4 class="skill-title">Доступность</h4>
        <p class="skill-text">
          Несмотря на то, что для к нашей работы мы привлекаем только лучших специалистов,
          услуги компании Serbess однозначно являются самыми доступными на рынке
        </p>
      </article>

      <article class="skill">
        <span class="skill-icon">
         <i class="far fa-grin-stars"></i>
        </span>
        <h4 class="skill-title">Престиж</h4>
        <p class="skill-text">
          Работа с нами поставит вас в один ряд с лучшими группами последних сорока лет.
          Пользование услугами компании Serbess безусловно является показателем статуса и позволит вам попасть в среду самых популярных музыкантов современности

        </p>
      </article>

      </section>
<section id='about'>
      <div class="section-center clearfix">
   
      <article class="about-img">
        <div class="about-picture-container">
       <img src="<%= request.getContextPath() %>/images/musical-group-rock-concert-a-crowd-of-people-at-a-concert-is-filming-a-video-on-their-phone_652844-616.jpg" class="about-picture"/>
        </div>
      </article>
      
      <article class="about-info">
       
        <div class="section-title">
          <h3 class='regular'>Краткая история компании</h3>
          <h2>Sergbess</h2>
        </div>
        
        <p class="about-text">
          Всё стало возможным в 1986 году, после начала перестройки. 
          В условиях спадающих запретов мы решили заняться тем, чего хотели всегда - организовывать концерты. 
          Первым крупным шансом стал концерт в Лужниках в 1989 году,
           однако несмотря на наши старания и общий успех мероприятия, долгие годы после него было затишье, и мы едва оставались на плаву.
           Всё изменилось в 2003 году, когда в Москву приехал Пол Маккартни. Организация этого события изменила всё, такой опыт позволил занять нам господствующее положение на рынке.
        </p>
        <a href="/about" class="btn">Узнать больше</a>
        </article>
        </div>
        </section>
         <section class="products" id='team'>
              <div class="section-center clearfix">
             
              <article class="products-info">
              
                <div class="section-title">
                  <h3>Знакомьтесь</h3>
                  <h2 class='regular'>Наша команда</h2>
                </div>
               
                <p class="product-text">
                  Все наши успехи неслучайны - компания Sergbess стала такой благодаря людям, стоявших у её истоков.
                  Руководство Сергея Дмитриевича, его умения найти нужные,самые добрые слова, технические и организационные таланты Костантина и Дмитрия -
                  именно это позволило нам стать собой. Основу Sergbess составляют 10 сотрудников, ниже вы можете ознакомиться со всеми.
                </p>
             <a href="/layout" class="btn">Ознакомиться</a>

              </article>
              
              <article class="products-inventory clearfix">
                
                <div class="product serg">
                <img src="<%= request.getContextPath() %>/images/pWo-EHs71vM.jpg" class="product-img"/>

                  <h4 class="product-title">Сергей Шандала</h4>
                  <h4 class="product-price">Основатель</h4>
                </div>
                <div class="product">

                <img src="<%= request.getContextPath() %>/images/653f744a-aee6-4515-aafe-d803b4226ce8.jpg" class="product-img"/>
                  <h4 class="product-title">Костантин Роков</h4>
                  <h4 class="product-price">Специалист по безопасности</h4>
                </div>
                <div class="product">
                <img src="<%= request.getContextPath() %>./images/715ebe67-b5a4-40d6-9bd6-ff6e263385f6.jpg" class="product-img"/>
                  <h4 class="product-title">Дмитрий Артистов</h4>
                  <h4 class="product-price">Технический райдер</h4>
                </div>
                
              </article>
              </div>
            </section>
               <div class="services" id='services'> 
                  
                    <div class="section-title services-title">
                      <h3>Грядущие</h3>
                      <h2>Концерты</h2>
                    </div>
                   
                    <div class=" section-center clearfix">
                     
                      <article class="service-card">
                      
                        <div class="service-img-container">
            <img src="<%= request.getContextPath() %>/images/ZAWFfTQKhSA.jpg" class="service-img"/>

            <span class="service-icon">
             <i class="fas fa-user"></i>
            </span>
                        </div>
                       
                        <div class="service-info">
                          <h4>Black Metal</h4>
                          <p>Энергичное рок-шоу с яркими световыми эффектами, динамичными выступлениями артистов и потрясающим звуком.</p>
                          <a href='/middle' class='btn service-btn'>Подробнее</a>
                        </div>
                      </article>
                     
                      <article class="service-card">
                        
                        <div class="service-img-container">
            
                        
                       <img src="<%= request.getContextPath() %>/images/hq720.jpg" class="service-img"/>
            <span class="service-icon">
              <i class="fas fa-headset"></i>
            </span>
                        </div>
                        
                        <div class="service-info">
                          <h4>Crystal Castles</h4>
                          <p>Интересное акустическое выступление , создающее атмосферу уюта и близости с публикой.
</p>
                          <a href="#contacts" class="btn service-btn" >Подробнее</a>
                        </div>
                      </article>
                      
                    </div>
                    </div>
                       <section class="contact">
                          <div class="section-center clearfix">
                    
                    <article class="contact-info">
                      
                      <div class="contact-item">
                        <h4 class="contact-title">
                          <span class="contact-icon">
                            <i class="fas fa-location-arrow" ></i>
                          </span>
                          Адрес
                        </h4>
                        <h4 class="contact-text">
                     308 Negra Aroya Lane <br/> Albuquerque, New Mexico, 87104.
                        </h4>
                      </div>
                     
                      <div class="contact-item">
                        <h4 class="contact-title">
                          <span class="contact-icon">
                            <i class="fas fa-envelope" ></i>
                          </span>
                          Почта
                        </h4>
                        <h4 class="contact-text">
                    email@email.com
                        </h4>
                      </div>
                      
                      <div class="contact-item">
                        <h4 class="contact-title">
                          <span class="contact-icon">
                            <i class="fas fa-phone"></i>
                          </span>
                          Телефон
                        </h4>
                        <h4 class="contact-text">
                          + 8 800 555 35 35
                        </h4>
                      </div>
                     
                    </article>
                    
                    <article class="contact-form" id='contacts'>
                      <h3 >Корпоративная почта</h3>
                      <form action="https://formspree.io/f/xjvzkpqy" method="POST">
                        <div class="form-group">
                          <input type="text" placeholder="Ваше имя" class="form-control" name="name"></input>
                          <input type="email" placeholder="Ваша почта" class="form-control" name="name"></input>
                          <textarea name="message"  placeholder="Суть вопроса"   rows="5" class="form-control"></textarea>
                        </div>
                        
                        <button type="submit" class="submit-btn btn">Подтвердить</button>
                      </form>
                    </article>
                          </div>
                        </section>
<footer class="footer">
    <div class="section-center">
        <div class="social-icons">
            <a href="#" class="social-icon">

            </a>
            <a href="#" class="social-icon">

            </a>
            <a href="#" class="social-icon">

            </a>
        </div>
        <h4 class="footer-text">
            &copy; <span id="date"><%= new java.util.Date().getYear() + 1900 %></span>
            <span class="company">Sergbess</span>
            Все права защищены
        </h4>
    </div>
</footer>

<script src="${contextPath}/app.js"></script>
</body>
</html>
