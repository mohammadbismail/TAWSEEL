<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet" href="css/style1.css" />
<body>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
 <!-- header -->
      <input type="checkbox" id="cart" />
      <label for="cart" class="label-cart"
        ><span class="fas fa-shopping-cart"></span
      ></label>
      <nav>
        <ul>
          <li><a href=""> All Restaurants</a></li>
          <li><a href=""> Logout</a></li>
          <li><a href=""> User Name </a></li>
          <li><a href=""> About Us</a></li>
        </ul>
      </nav>
      

      <!-- main dashboard -->
      <div class="dashboard">
        <div class="dashboard-banner">
          <img src="images/images-banner.jpg" />
          <div class="banner-promo">
            <h1>
              <span>Satisfy</span><br />
              Your Hunger <br />
              With Our Service
            </h1>
          </div>
        </div>

       
        <div id="dashboard-content">
          <div class="order-details">
            <section class="header">
              <h1>Order Summary</h1>
              <p><a href="">Edit Order</a></p>
            </section>
            <section class="name">
            <c:out value=""></c:out> 
            </section>
            <section class="details">
              <table>
                <thead>
                  <tr>
                    <th>Item(s)</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                  </tr>
                </thead>
<!--                 <tbody> -->
<%--                   <c:forEach var="" items=""> --%>
<!--                     <tr> -->
<%--                       <td><c:out value=""></c:out></td> --%>
<%--                       <td><c:out value=""></c:out></td> --%>
<%--                       <td><c:out value=""></c:out></td> --%>
<%--                       <td><c:out value=""></c:out></td> --%>
<!--                     </tr> -->
<%--                   </c:forEach> --%>
<!--                 </tbody> -->
              </table>
            </section>
          </div>
          <div class="delivery-details">
            <h1>Address</h1>
            <!-- <p><a href="">Add</a></p> -->
<%--             <form:form action="" method="" modelAttribute=""> --%>
<!--               <div> -->
<%--                 <form:label path="city">City: </form:label> --%>
<!--                 <br/> -->
<%--                 <form:errors path="city"/> --%>
<%--                 <form:input type="text" path="city"/> --%>
<!--               </div> -->
        
<!--               <div> -->
<%--                 <form:label path="street">Street: </form:label> --%>
<!--                 <br/> -->
<%--                 <form:errors path="street"/> --%>
<%--                 <form:input  type="text" path="street"/> --%>
<!--               </div> -->
        
<!--               <div> -->
<%--                 <form:label path="building">Building: </form:label> --%>
<!--                 <br/> -->
<%--                 <form:errors path="building"/> --%>
<%--                 <form:input type="text" path="building"/> --%>
<!--               </div> -->
<!--               <div> -->
<%--                 <form:label path="floor">Floor: </form:label> --%>
<!--                 <br/> -->
<%--                 <form:errors path="floor"/> --%>
<%--                 <form:input type="text" path="building"/> --%>
<!--               </div> -->
        
<!--               <div> -->
<!--                 <input type="submit" value="Submit"/> -->
<!--               </div> -->
<%--             </form:form> --%>
          </div>
        
        </div>
        <div class="dashboard-order">
          <h1>Payment Summary</h1>
          <div class="order-address">
            <p>Select your payment method</p>
            <div>
              <input type="radio" name="font" value="credit" id="credit" />
              <label for="credit"
                ><strong>Credit Card </strong
                ><i class="fa fa-credit-card" aria-hidden="true"></i
              ></label>
            </div>
            <div>
              <input type="radio" name="font" value="cash" id="cash" />
              <label for="cash"
                ><strong>Cash </strong
                ><i class="fa fa-money" aria-hidden="true"></i
              ></label>
            </div>
          </div>
          
        </div>
      </div>
    </body>
  </head>
</html>


</body>
</html>