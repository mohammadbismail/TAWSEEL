<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dashbord</title>
</head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="/css/order.css" />
<body>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
 <!-- header -->
    <input type="checkbox" id="cart">
    <label for="cart" class="label-cart"><span class="fas fa-shopping-cart"></span></label>
       <nav>
          <ul>
              <li> <a href=""> All Restaurants</a></li>
              <li><a href=""> Logout</a></li>
              <li><a href=""> User Name </a></li>
              <li> <a href=""> About Us</a></li>
          </ul>
          </nav>



    <!-- main dashboard -->
    <div class="dashboard">
        <div class="dashboard-banner">
            <img src="images/images-banner.png">
            <div class="banner-promo">
                <h1><span>Satisfy</span><br>
                Your Hunger <br> With Our Service </h1>
            </div>
        </div>
        
        
        
			<!-- Menu -->
<!-- 			<div class="restaurant-name"> -->
<!-- 			<h2>Chinese Food Restaurant</h2> -->
<!-- 			</div> -->
			
<!--         <div class="menu-content"> -->
        
<!--         	<div class="foodinfo"> -->
<!--             <section class="menu-list"> -->
<!--             <img src="images/"> -->
<!--             <img src="images/"> -->
<!--             <img src="images/"> -->
<!--             <img src="images/"> -->
<!--             </section> -->
            
            
<!--             <section class="menu-list"> -->
<!--             <p>good food</p> -->
<!--             <p>good food</p> -->
<!--             <p>good food</p> -->
<!--             <p>good food</p> -->
<!--             </section> -->
            
<!--             </div> -->
            
            
            
<!--             <div class="foodprice"> -->
            
<!--             <section class="menu-list"> -->
<!--   				<button></button> -->
<!--   				<button></button> -->
<!--   				<button></button> -->
<!--   				<button></button> -->
<!--             </section> -->
            
            
<!--             <section class="menu-list"> -->
<!-- 					<p>price</p> -->
<!-- 					<p>price</p> -->
<!--             		<p>price</p> -->
<!--             </section> -->
            
            

<!--             </div> -->
<!--         </div> -->
<!--     </div> -->


<div class="dashboard-content">
            <div class="foodinfo">
            <section class="menu-list">
            <img src="images/images8.jpg">
            <p>Green Salad</p>
            </section>


            <section class="menu-list">
            <img src="images/images7.jpg">
            <p>Barbeque Pizza</p>
            </section>


            <section class="menu-list">
            <img src="images/images3.jpg">
            <p>Chinese Food</p>
            </section>
            
            
             <section class="menu-list">
            <img src="images/images7.jpg">
            <p>Chinese Food</p>
            </section>
            
            
             <section class="menu-list">
            <img src="images/images8.jpg">
            <p>Chinese Food</p>
            </section>
            
             <section class="menu-list">
            <img src="images/images8.jpg">
            <p>Chinese Food</p>
            </section>
            
             <section class="menu-list">
            <img src="images/images3.jpg">
            <p>Chinese Food</p>
            </section>

            </div>



            <div class="foodprice">

            <section class="menu-list">
            <p>₪35</p>
                <div> <button class="button"> + </button> </div>
            </section>


            <section class="menu-list">
            <p>₪45</p>
                <div> <button class="button"> + </button> </div>
            </section>


            <section class="menu-list">
            <p>₪55</p>
             <div> <button class="button"> + </button> </div>
            </section>
            
            <section class="menu-list">
            <p>₪55</p>
             <div> <button class="button"> + </button> </div>
            </section>
            
            <section class="menu-list">
            <p>₪45</p>
            <div> <button class="button"> + </button> </div>
            </section>
            </div>


        </div>
    </div>
    
    <div class="dashboard-order">
        <h3>Order Menu</h3> 
        <div class="order-address"> 
            <p>Address Delivery</p> 
            <h4>birzeit al maraj</h4>
        </div>
        <div class="order-time">
            <span class="fas fa-clock"></span> 30 mins <span class="fas fa-map-marker-alt"></span>2 km
       </div>

        <div class="order-wrapper">
            <div class="order-card">
                <img class="order-image" src="images/images7.jpg">
                <div class="order-detail">
                    <p>Barbeque Pizza</p>
                    <i class="fas fa-times"></i> <input type="text" value="1">
                </div>
                <h4 class="order-price">₪40</h4>
            </div>
            <div class="order-card">
                <img class="order-image" src="images/images8.jpg">
                <div class="order-detail">
                    <p>Green Salad</p>
                    <i class="fas fa-times"></i> <input type="text" value="2">
                </div>
                <h4 class="order-price">₪35</h4>
            </div>
            <div class="order-card">
                <img class="order-image" src="images/images3.jpg">
                <div class="order-detail">
                    <p>Chinese dish</p>
                    <i class="fas fa-times"></i> <input type="text" value="1">
                </div>
                <h4 class="order-price">₪23</h4>
            </div>
        </div>
        <hr class="divider">
        <div class="order-total">
            <p>Subtotal <span>₪98</span></p>
            <p>Delivery Fee <span>₪20</span></p>

            <hr class="divider">
            <p>Total <span>₪118 </span></p>
        </div>
        <button class="checkout">
            Checkout
        </button>
    </div>
</body>
</html>