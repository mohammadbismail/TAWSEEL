<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="/css/style1.css" />
<body>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
 <!-- header -->
    <input type="checkbox" id="cart">
    <label for="cart" class="label-cart"><span class="fas fa-shopping-cart"></span></label>
       <nav>
         <c:choose>
      		<c:when test="${currentUser!=null }">

          <ul>
            <li style="color:white"> ${currentUser.username}</li>
              <li><a href=""> home page</a></li>
              <li> <a href=""> About Us</a></li>
              <li> <a href="/logout"> Logout</a></li>
             
          </ul>
          </c:when>
          <c:otherwise>
          
          <ul>
          
              <li><a href="/"> home page</a></li>
              <li> <a href=""> About Us</a></li>
              <li> <a href="/login"> Login/signup</a></li>
             
          </ul>
          </c:otherwise>
          </c:choose>
          </nav>


    <!-- sidebar -->
<!--     <div class="sidebar"> -->
<!--         <div class="sidebar-menu"> -->
<!--             <span class="fas fa-search"></span> -->
<!--             <a href="#">About</a> -->
<!--         </div> -->
<!--         <div class="sidebar-menu"> -->
<!--             <span class="fas fa-home"></span> -->
<!--             <a href="#">Services</a> -->
<!--         </div> -->
<!--         <div class="sidebar-menu"> -->
<!--             <span class="fas fa-heart"></span> -->
<!--             <a href="#">Your Orders</a> -->
<!--         </div> -->
<!--         <div class="sidebar-menu"> -->
<!--             <span class="fas fa-user"></span> -->
<!--             <a href="#">Address</a> -->
<!--         </div> -->
<!--         <div class="sidebar-menu"> -->
<!--             <span class="fas fa-sliders-h"></span> -->
<!--             <a href="#">Help</a> -->
<!--         </div> -->
<!--     </div> -->

    <!-- main dashboard -->
    <div class="dashboard">
        <div class="dashboard-banner">
            <img src="/images/images-banner.jpg">
            <div class="banner-promo">
                <h1><span>Satisfy</span><br>
                Your Hunger <br> With Our Service </h1>
            </div>
        </div>
      <!-- <div class="main">
        <img src="images/barbeque.jpg">
        <p></p>
      </div> -->
        <!-- <h3 class="dashboard-title">Recommend Food For You</h3>
        <div class="dashboard-menu">
		<select name="City" id="">
  			<option value="Ramallah">Ramallah</option>
  			<option value="Bethlehem">Bethlehem</option>
  			<option value="Hebron">Hebron</option>
 			 <option value="Nablus">Nablus</option>
 			 <option value="">Jenin</option>
 			 <option value="">Tulkarem</option>
		</select> -->
        
<!--         
        	<select name="Food Type" id="">
  			<option value="">Traditional Food </option>
  			<option value="">Fast Food</option>
  			<option value="">Chinese Food</option>
 			 <option value=""></option>
 			 <option value=""></option>
 			 <option value=""></option>
		</select>
        </div> -->

        <div class="dashboard-content">
                   
        
            <div class="foodinfo">
             <c:forEach var="i" items="${restaurant.item}">
            <section class="menu-list">
                <img src="${i.image}">
                <p>${i.name}</p>
            </section>
             </c:forEach>
            </div>
           
            <div class="foodprice">
            <c:forEach var="i" items="${restaurant.item}">
            <section class="menu-list">
                <p>₪${i.price}</p>
                <form action="/neworder/${i.id}" >
                <button class="button" name="idR" value="${restaurant.id}">+</button> 
                </form>
            </section>
            </c:forEach>
            
            
            
            </div>
           
            
             </div>
    
                <!-- <img class="card-image" src="images/images1.png">
                <div class="card-detail">
                    <h4>Barbeque PIZZA</h4>
                    <p> pizza, various sandwiches, pasta in various shapes and sauces and much more</p>
                    
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="images/images2.jpg">
                <div class="card-detail">
                    <h4>Zarb Restaurant</h4>
                    <p>zareb, grilled chicken, grilled meat, maqluba, appetizers, soups and much more</p>
                  
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="images/images3.jpg">
                <div class="card-detail">
                    <h4>Chinese Food</h4>
                    <p>Chinese main dishes, soups, appetizers, sea food, dessert, soft drinks and much more</p>
                   
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="images/images4.jpg">
                <div class="card-detail">
                    <h4>Jezzine restaurant</h4>
                    <p>steak,grilled chicken, grilled meat,sea food, dessert, soft drinks and much more  </p>
                   
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="images/images5.jpg">
                <div class="card-detail">
                    <h4>Crepello Palestine</h4>
                    <p>desserts, pizza, various sandwiches, pasta in various shapes and much more</p>
                    
                </div>
            </div>
            <div class="dashboard-card">
                <img class="card-image" src="images/images6.jpg">
                <div class="card-detail">
                    <h4>Full Meat</h4>
                    <p>burger, fries, various sandwiches,soft drinks steak and much more</p>
                    
                </div> -->
            <!-- </div> -->
        

    
    <div class="dashboard-order">
        <h3>Order Menu</h3> 
        <div class="order-address"> 
            <p>Address Delivery</p> 
            <h4>${restaurant.name}</h4>
        </div>
        <div class="order-time">
            <span class="fas fa-clock"></span> 15 mins <span class="fas fa-map-marker-alt"></span>0.5 km
       </div>

        <div class="order-wrapper">
        <c:forEach var="i" items="${order.item }">
            <div class="order-card">
                <img class="order-image" src="${i.image }">
                <div class="order-detail">
                    <p>${i.name}</p>
                    <i class="fas fa-times"></i> <input type="text" value="1">
                </div>
                <h4 class="order-price">₪${i.price}</h4>
            </div>
            </c:forEach>
           
        </div>
        <hr class="divider">
        <div class="order-total">
            <p>Subtotal <span>₪ ${sum}</span></p>
            <p>Delivery Fee <span>₪20</span></p>

            <hr class="divider">
            <p>Total <span>₪${sum+20} </span></p>
           <a href="/order" ><button class="checkout btn">Checkout</button></a>
        </div>
       
    </div>
</body>
</html>